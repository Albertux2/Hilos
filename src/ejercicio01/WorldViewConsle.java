package ejercicio01;


public class WorldViewConsle extends WorldView {

	@Override
	public void showInstant(WorldPresenter worldPresenter) {
		System.out.println("-------------------------------");
		System.out.println("------  ESTADO DEL MUNDO  -----");
		worldPresenter.getBeings().stream().filter((b)->b.isAliveNow()).forEach((b)->{b.present();});
		System.err.println("hemos comsumido "+worldPresenter.getConsumedFood());
	}

}
