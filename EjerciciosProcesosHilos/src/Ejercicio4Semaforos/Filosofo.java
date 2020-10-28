package Ejercicio4Semaforos;

import java.util.concurrent.Semaphore;

public class Filosofo extends Thread{
	private Semaphore semaphore, semaphore2;
	private Palillo palillo, palillo2;
	private int i;
	/*
	public Filosofo(Semaphore semaphore, Semaphore semaphore2, int i, int[] palillos) {
		this.setSemaphore(semaphore);
		this.setSemaphore2(semaphore2);
		this.setName(Integer.toString(i));
		
	}
	*/
	public Filosofo(Semaphore semaphore, Semaphore semaphore2, int i2, Palillo palillo, Palillo palillo2) {
		this.setSemaphore(semaphore);
		this.setSemaphore2(semaphore2);
		this.setPalillo(palillo);
		this.setPalillo2(palillo2);
		this.setName(Integer.toString(i));
	}

	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void setSemaphore2(Semaphore semaphore2) {
		this.semaphore2 = semaphore2;
	}
	
	public Semaphore getSemaphore() {
		return semaphore;
	}
	
	public Semaphore getSemaphore2() {
		return semaphore2;
	}

	public Palillo getPalillo() {
		return palillo;
	}

	public void setPalillo(Palillo palillo) {
		this.palillo = palillo;
	}

	public Palillo getPalillo2() {
		return palillo2;
	}

	public void setPalillo2(Palillo palillo2) {
		this.palillo2 = palillo2;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	public void run() {
		boolean eject=true;
		while(eject==true) {
			System.out.println("Filosofo"+this.getName()+" Piensa");
			this.getSemaphore().acquireUninterruptibly();
			System.out.println("Obtiene palillo"+i);
			this.palillo.usar();
			this.getSemaphore2().acquireUninterruptibly();
			System.out.println("Obtiene palillo"+((i++)%5));
			this.palillo2.usar();
			System.out.println("Filosofo"+this.getName()+" Consigue comer");
			this.getSemaphore().release();
			this.palillo.dejarUsar();
			this.getSemaphore2().release();
			this.palillo2.dejarUsar();
		}
	}
}
