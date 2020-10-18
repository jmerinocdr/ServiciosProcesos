package Ejercicio11Semaforos2;

import java.util.concurrent.Semaphore;

public class HiloP1 extends Thread{
	private Semaphore fin;
	public HiloP1(String name, Semaphore finp1) {
		this.setName(name);
		this.setFin(finp1);
	}
	public Semaphore getFin() {
		return fin;
	}
	public void setFin(Semaphore fin) {
		this.fin = fin;
	}
	
	public void run() {
		System.out.println(this.getName()+" Intento ejecutarme");
		try {
			System.out.println(this.getName()+" Estoy ejecutandome");
			sleep(800+((long)Math.random()*2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fin.release();
		fin.release();
		System.out.println(this.getName()+" Terminé de ejecutarme");
	}
	
}
