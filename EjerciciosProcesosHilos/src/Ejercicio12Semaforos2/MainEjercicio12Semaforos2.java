package Ejercicio12Semaforos2;

import java.util.concurrent.Semaphore;

public class MainEjercicio12Semaforos2 {

	public static void main(String[] args) {
		Semaphore semaforoDespierto=new Semaphore(0);
		Semaphore semaforoSilla=new Semaphore(1);
		Semaphore semaforoSillas=new Semaphore(5);
		Peluquero peluquero=new Peluquero(semaforoDespierto);
		peluquero.start();
		for(int i=0; i<100; i++) {
			Cliente cliente=new Cliente(i,semaforoSilla, semaforoSillas, semaforoDespierto);
			cliente.start();
		}
	}

}
