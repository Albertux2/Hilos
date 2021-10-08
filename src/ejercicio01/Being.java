package ejercicio01;

import java.util.Random;

public class Being extends Thread {
    private final int MAXLONGLIFE = 120;
    private final int ANNUALFEED = 1;
    private static int order = 0;

    private int id;
    private int lifeExpectancy;
    private int actualLife = 0;
    private boolean alive = true;
    Cornucopia cornucopia;

    public Being(Cornucopia cornucopia) {
        super();
        lifeExpectancy = new Random().nextInt(MAXLONGLIFE);
        id = order++;
        this.cornucopia = cornucopia;
    }

    public void feed() {
        actualLife += cornucopia.provide(ANNUALFEED);
    }

    @Override
    public void run() {
        while (isAliveNow()) {

            this.feed();
            this.aging();
            if (isAliveNow()) {
                this.present();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }

    // Esta haciendo dos cosas. minima sorpresa
    // public boolean aging() {
    // actualLife++;
    // return actualLife<lifeExpectancy;
    // }
    public void aging() {
        actualLife++;
        setAlive(actualLife < lifeExpectancy);
    }

    private void setAlive(boolean result) {
        alive = result;
    }

    public boolean isAliveNow() {
        return alive;
    }

    public void present() {
        System.out.println("Soy " + id + " y tengo " + actualLife + " estoy vivo? " + isAliveNow());

    }
}
