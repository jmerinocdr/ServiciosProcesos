package Ejercicio4Semaforos;

import java.util.concurrent.Semaphore;

public class MainEjercicio4Semaforos {

	public static void main(String[] args) {
		int[] palillos=new int[5];
		Semaphore escritoraPalillos=new Semaphore(1);
		Semaphore[] S=new Semaphore[5]; 
		for(int i=0; i<5; i++) {
			S[i]=new Semaphore(0);
		}
		
		for(int i=0; i<5; i++) {
			Filosofo filosofo=new Filosofo(S[i], S[(i++)%5], i, palillos);
			filosofo.start();
		}

	}

}
