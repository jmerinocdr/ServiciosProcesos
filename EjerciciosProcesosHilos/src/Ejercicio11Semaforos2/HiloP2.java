package Ejercicio11Semaforos2;

import java.util.concurrent.Semaphore;

public class HiloP2 extends Thread{
	private Semaphore principio;
	private Semaphore fin;
	
	public HiloP2(String name, Semaphore finp1, Semaphore finp2) {
		this.setName(name);
		this.setFin(finp2);
		this.setPrincipio(finp1);
	}
	private void setFin(Semaphore fin) {
		this.fin = fin;
	}
	
	private void setPrincipio(Semaphore principio) {
		this.principio = principio;
	}
	
	
	public void run() {
		System.out.println(this.getName()+" Intento ejecutarme");
		try {
			principio.acquireUninterruptibly();
			System.out.println(this.getName()+" Estoy ejecutandome");
			sleep(800+((long)Math.random()*2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fin.release();
		System.out.println(this.getName()+" Termin� de ejecutarme");
	}
	
}