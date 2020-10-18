package Ejercicio11Semaforos2;

import java.util.concurrent.Semaphore;

public class HiloP6 extends Thread{
	private Semaphore principio2;
	private Semaphore principio;
	
	public HiloP6(String name, Semaphore finp3, Semaphore finp4) {
		this.setName(name);
		this.setPrincipio(finp3);
		this.setPrincipio2(finp4);
	}
	private void setPrincipio(Semaphore principio) {
		this.principio = principio;
	}
	
	private void setPrincipio2(Semaphore principio2) {
		this.principio2 = principio2;
	}
	
	
	public void run() {
		System.out.println(this.getName()+" Intento ejecutarme");
		try {
			principio.acquireUninterruptibly();
			principio2.acquireUninterruptibly();
			System.out.println(this.getName()+" Estoy ejecutandome");
			sleep(800+((long)Math.random()*2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getName()+" Terminé de ejecutarme");
	}
	
}