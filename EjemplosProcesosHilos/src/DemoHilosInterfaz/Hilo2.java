package DemoHilosInterfaz;

public class Hilo2 extends Figura implements Runnable{
	private Thread miHilo=null;
	public Hilo2 (String str) {
		miHilo = new Thread (this, str);
		miHilo.start();
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(i+" "+miHilo.getName());
			try {
				miHilo.sleep((long)(Math.random()* 1000));
			}
			catch (InterruptedException e) {}
		}
		System.out.println("FIN"+miHilo.getName());
	}
	
}
