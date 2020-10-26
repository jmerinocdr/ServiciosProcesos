package Ejercicio4Semaforos;

import java.util.concurrent.Semaphore;

public class Filosofo extends Thread{
	private Semaphore semaphore, semaphore2;
	private int[] palillos;
	
	public Filosofo(Semaphore semaphore, Semaphore semaphore2, int i, int[] palillos) {
		this.setSemaphore(semaphore);
		this.setSemaphore2(semaphore2);
		this.setName(Integer.toString(i));
		
	}

	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void setSemaphore2(Semaphore semaphore2) {
		this.semaphore2 = semaphore2;
	}
	
	public void setInt(int[] palillos) {
		this.palillos = palillos;
	}
	
	public void run() {
		System.out.println("Piensa");
		//espera palilloi
		//espera palillo(i++)%5
		System.out.println("Comer");
		this.semaphore.acquireUninterruptibly();
		
		this.semaphore2.release();
	}

}
