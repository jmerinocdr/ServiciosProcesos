package Ejercicio2Semaforos;

import java.util.concurrent.Semaphore;

public class Productor extends Thread {
	private int[] array;
	private Semaphore S;

	public Productor(Semaphore S, int[] array) {
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
		boolean ejec=true;
		while(ejec==true) {
		System.out.println("Productor - Intento escribir los datos");

		S.acquireUninterruptibly();
		if (array[0] != 0) {
			System.out.println("Productor - El array contiene información");
			int cont = 1;
			boolean sum = true;
			for (int i = 0; i < array.length; i++) {
				if (array[i] != 0 && sum == true) {
					System.out.println("Productor - La posición " + i + " del array tiene un valor de " + array[i]);
					try {
						sleep((int) (Math.random() * 2000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					cont++;
				} else if (sum == true) {
					System.out.println("Productor - La posición " + i
							+ " del array está vacía, se le ha asignado valor de " + cont);
					try {
						sleep((int) (Math.random() * 2000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					array[i] = cont;
					sum=false;
				} else {
					System.out.println(
							"Productor - La posición " + i + " del array está vacía, no se le ha asignado valor");
				}
			}
			System.out.println("Productor - He terminado el proceso del array");
		} else {
			System.out.println("Productor - El array no contiene información");
			if (array[0] == 0 && array[1] == 0) {
				System.out.println("Productor - La posición 0 del array está vacía, se le ha asignado valor de 1");
				array[0]=1;
				try {
					sleep((int) (Math.random() * 2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println("Productor - Libero el proceso");
		S.release();
	}
	}

}
