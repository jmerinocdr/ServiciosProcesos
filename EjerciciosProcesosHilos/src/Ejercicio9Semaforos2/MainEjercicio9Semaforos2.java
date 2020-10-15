package Ejercicio9Semaforos2;

import java.util.concurrent.Semaphore;

public class MainEjercicio9Semaforos2 {

	public static void main(String[] args) {
		Semaphore S=new Semaphore(8);
		for(int i=0; i<100; i++) {
			Partido partido=new Partido(i, S);
			partido.start();
		}
		
	}

}
