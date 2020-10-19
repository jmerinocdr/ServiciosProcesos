package Ejercicio3Semaforos;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {
	private Semaphore principio;
	private Semaphore fin;
	private Semaphore S;
	private int[] array;

	public Consumidor(Semaphore principio, Semaphore fin, String i, int[] array, Semaphore S) {
		this.setName(i);
		this.setPrincipio(principio);
		this.setFin(fin);
		this.setArray(array);
		this.setS(S);

	}

	private void setPrincipio(Semaphore principio) {
		this.principio = principio;
	}

	private void setFin(Semaphore fin) {
		this.fin = fin;
	}

	private void setS(Semaphore S) {
		this.S = S;
	}

	private void setArray(int[] array) {
		this.array = array;
	}

	public void run() {
		boolean eject = true;
		while (eject == true) {
			System.out.println("Consumidor" + this.getName() + " Intenta acceder al array");
			S.acquireUninterruptibly();
			principio.acquireUninterruptibly();
			System.out.println("Consumidor" + this.getName() + " - Intento consumir");
			int random = (int) Math.floor(Math.random() * 4);
			System.out.println("Consumidor" + this.getName() + " - Consume dato array " + random + " con valor "
					+ this.array[random]);
			try {
				sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fin.release();
			S.release();
			System.out.println("Consumidor" + this.getName() + " - Deja de consumir");
		}
	}

}
