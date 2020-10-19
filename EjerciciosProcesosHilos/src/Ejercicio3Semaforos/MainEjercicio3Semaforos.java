package Ejercicio3Semaforos;

import java.util.concurrent.Semaphore;

public class MainEjercicio3Semaforos {

	public static void main(String[] args) {
		Semaphore S=new Semaphore(2);
		Semaphore h1h2=new Semaphore(0);
		Semaphore h2h3=new Semaphore(0);
		Semaphore h3h1=new Semaphore(1);
		
		int[] array= {0,0,0,0,0};
		
		Productor productor =new Productor("Productor", array, S);
		
		Consumidor consumidor1=new Consumidor(h3h1,h1h2,"1", array, S);
		Consumidor consumidor2=new Consumidor(h1h2,h2h3,"2", array, S);
		Consumidor consumidor3=new Consumidor(h2h3,h3h1,"3", array, S);
		
		productor.start();
		consumidor1.start();
		consumidor2.start();
		consumidor3.start();

		
	}
}
