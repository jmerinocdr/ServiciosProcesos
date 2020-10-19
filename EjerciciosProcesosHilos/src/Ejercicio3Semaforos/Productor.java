package Ejercicio3Semaforos;

import java.util.concurrent.Semaphore;

public class Productor extends Thread {
	private int[] array;
	private Semaphore S;

	public Productor(String name, int[] array, Semaphore S) {
		this.setName(name);
		this.setArray(array);
		this.setS(S);
	}

	private void setArray(int[] array) {
		this.array = array;
	}

	private void setS(Semaphore S) {
		this.S = S;
	}

	public void run() {
		int cont=0;
		boolean eject = true;
		while (eject == true) {
			for (int i = 0; i < array.length; i++) {
				System.out.println(this.getName() + " Intenta acceder al array");
				S.acquireUninterruptibly();
				array[i] = cont;
				System.out.println(this.getName() + " Establece la posicion " + i + " con valor " + cont);
				S.release();
				try {
					sleep((int) (Math.random() * 2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 cont++;
			}
		}
	}

}
