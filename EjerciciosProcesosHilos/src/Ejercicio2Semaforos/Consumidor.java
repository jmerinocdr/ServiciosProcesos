package Ejercicio2Semaforos;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {
	private int[] array;
	private Semaphore S;

	public Consumidor(Semaphore S, int[] array) {
		this.setS(S);
		this.setArray(array);
	}

	private void setS(Semaphore s) {
		S = s;
	}

	private void setArray(int[] array) {
		this.array = array;
	}

	public void run() {
		boolean eject=true;
		while(eject==true) {
		System.out.println("Consumidor - Intento leer los datos");

		S.acquireUninterruptibly();
		if (array[0] != 0) {
			System.out.println("Consumidor - El array contiene informaci�n");
			boolean sum = true;
			for (int i = 0; i < array.length; i++) {
				if (array[i] != 0 && sum == true) {
					System.out.println("Consumidor - La posici�n " + i + " del array tiene un valor de " + array[i]);
					try {
						sleep((int) (Math.random() * 2000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println(
							"Consumidor - La posici�n " + i + " del array est� vac�a, no se le ha asignado valor");
				}
			}
			System.out.println("Consumidor - He terminado el proceso del array");
		} else {
			System.out.println("Consumidor - El array no contiene informaci�n");
		}

		System.out.println("Consumidor - Libero el proceso");
		S.release();
	}
	}
}
