package Ejercicio4Semaforos;

import java.util.concurrent.Semaphore;

public class MainEjercicio4Semaforos {

	public static void main(String[] args) {
		Palillo[] palillos=new Palillo[5];
		Semaphore[] palillo=new Semaphore[5]; 
		for(int i=0; i<5; i++) {
			palillos[i]=new Palillo(i);
			palillo[i]=new Semaphore(1);
		}
		
		for(int i=0; i<5; i++) {
			Filosofo filosofo=new Filosofo(palillo[i], palillo[(i++)%5], i, palillos[i], palillos[(i++)%5]);
			filosofo.start();
		}

	}

}
