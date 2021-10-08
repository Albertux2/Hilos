package ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class World {
    private List<Being> beings = new ArrayList<>();
    private final int MAXBEINGS = 20;
    private Cornucopia cornucopia = Cornucopia.getInstance();
    private boolean fullWorld = false;
    private WorldView view;

    public World(WorldView view) {
        super();
        this.view = view;
    }

    public void makeHistory() {
        WorldPresenter worldPresenter = new WorldPresenter();
        do {
            if (!isFullWorld()) {
                Being b = new Being(cornucopia);
                beings.add(b);
                b.start();
                setFullWorld(checkFullBox());
            }
            view.showInstant(worldPresenter.getInstant(this));
            beings = beings.stream().filter((b)->b.isAliveNow()).collect(Collectors.toList());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (isAnyoneIn());

    }

    public boolean isFullWorld() {
        return fullWorld;
    }

    public void setFullWorld(boolean fullWorld) {
        this.fullWorld = fullWorld;
    }

    private boolean isAnyoneIn() {
        return beings.size() > 0;
    }

    public List<Being> getBeings() {
        return beings;
    }

    public long getConsumed() {
        return cornucopia.getConsumed();
    }

    private boolean checkFullBox() {
        return beings.size() >= MAXBEINGS;
    }

}
