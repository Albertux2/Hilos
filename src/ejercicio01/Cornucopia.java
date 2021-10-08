package ejercicio01;


public class Cornucopia {
	public long getConsumed() {
		return consumed;
	}

	//que ellos apliquen en singleton
	private long consumed = 0;
	private static Cornucopia cornucopia = new Cornucopia();

	private Cornucopia() {
		super();
	}

	public static Cornucopia getInstance() {
		return cornucopia;
	}

	public int provide(int amount) {
		consumed+=amount;
		return amount;
	}

}
