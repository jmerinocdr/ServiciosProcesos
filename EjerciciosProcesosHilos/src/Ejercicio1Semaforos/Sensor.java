package Ejercicio1Semaforos;

import java.util.concurrent.Semaphore;

public class Sensor extends Thread{
	private int i=0;
	private Semaphore scontador;
	private Contador contador;
	public Sensor(Semaphore scontador, int i, Contador contador) {
		this.setscontador(scontador);
		this.setI(i);
		this.setContador(contador);
	}
	
	private int getI() {
		return i;
	}

	private void setI(int i) {
		this.i = i;
	}
	
//	private Contador getContador() {
//		return contador;
//	}

	private void setContador(Contador contador) {
		this.contador = contador;
	}

//	private Semaphore getscontador() {
//		return scontador;
//	}
	private void setscontador(Semaphore scontador) {
		this.scontador = scontador;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
				System.out.println(this.getI()+"scontador cuenta un coche");
				scontador.acquireUninterruptibly();
				int newContador = contador.getContador()+1;
				try {
					contador.setContador(newContador);
					sleep(800+((long)Math.random()*2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				scontador.release();
		}
		System.out.println("El contador contiene "+contador.getContador());
	}
}
