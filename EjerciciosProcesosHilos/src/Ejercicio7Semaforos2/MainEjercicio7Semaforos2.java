package Ejercicio7Semaforos2;

import java.util.concurrent.Semaphore;

public class MainEjercicio7Semaforos2 {

	public static void main(String[] args) {
		Semaphore cuartel=new Semaphore(500);
		Semaphore mostradores=new Semaphore(5);
		Semaphore abridores=new Semaphore(50);
		Semaphore postre=new Semaphore(3);
		
		for(int i=0; i<10000; i++) {
			Soldado soldado=new Soldado(i, cuartel, mostradores, abridores, postre);
			soldado.start();
		}
	}

}
