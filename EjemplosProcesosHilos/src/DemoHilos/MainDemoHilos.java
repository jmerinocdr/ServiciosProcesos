package DemoHilos;

public class MainDemoHilos {

	public static void main(String[] args) {
		Hilo primero=new Hilo("primero");
		Hilo segundo=new Hilo("segundo");
		primero.start();
		segundo.start();
	}

}
