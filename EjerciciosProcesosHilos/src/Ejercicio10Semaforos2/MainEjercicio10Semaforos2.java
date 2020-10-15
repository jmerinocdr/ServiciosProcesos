package Ejercicio10Semaforos2;

import java.util.concurrent.Semaphore;

public class MainEjercicio10Semaforos2 {
	public static void main(String[] args) {
		Semaphore comida=new Semaphore(2);
		Semaphore rueda=new Semaphore(1);
		for(int i=0; i<100; i++) {
			Hamster hamster=new Hamster(i, comida, rueda);
			hamster.start();
		}
		
	}
}
