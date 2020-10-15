package Ejercicio8Semaforos2;

import java.util.concurrent.Semaphore;

public class Proceso extends Thread{
	private int num;
	private Semaphore procesofin;
	private Semaphore procesoinicio;
	public Proceso(int num, Semaphore procesofin, Semaphore procesoinicio) {
		setNum(num);
		setprocesofin(procesofin);
		setprocesoinicio(procesoinicio);
	}
	
	public Semaphore getprocesofin() {
		return procesofin;
	}

	public Semaphore getprocesoinicio() {
		return procesoinicio;
	}

	public void setprocesofin(Semaphore procesofin) {
		this.procesofin = procesofin;
	}

	public void setprocesoinicio(Semaphore procesoinicio) {
		this.procesoinicio = procesoinicio;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void run() {
		System.out.println("Intento ejecutar proceso "+num);
		try {
			procesoinicio.acquireUninterruptibly();
			System.out.println("Proceso "+num+" se está ejecutando");
			sleep(800+((long)Math.random()*2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Proceso "+num+" termino de ejecutar");
		procesofin.release();
		System.out.println("Hamster "+num+" Siguiente proceso");
		
	}
	
	
}
