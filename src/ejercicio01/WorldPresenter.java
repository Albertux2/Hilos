package ejercicio01;

import java.util.List;

public class WorldPresenter {
	private List<Being> beings;
	private long consumedFood;

	public WorldPresenter() {
	}

	public WorldPresenter getInstant(World world) {
		beings = world.getBeings();
		consumedFood = world.getConsumed();
		return this;
	}

	public long getConsumedFood() {
		return consumedFood;
	}

	public List<Being> getBeings() {
		return beings;
	}

}
