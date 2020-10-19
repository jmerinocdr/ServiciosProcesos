package Ejercicio2Semaforos;

import java.util.concurrent.Semaphore;

public class MainEjercicio2Semaforos {

	public static void main(String[] args) {
		Semaphore S = new Semaphore(1);
		int[] array = { 0, 0, 0, 0, 0 };

		Productor productor = new Productor(S, array);
		Consumidor consumidor = new Consumidor(S, array);

		
			productor.start();
			consumidor.start();
			
		

	}

}
