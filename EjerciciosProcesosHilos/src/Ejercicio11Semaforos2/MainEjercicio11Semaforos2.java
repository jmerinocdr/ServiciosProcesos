package Ejercicio11Semaforos2;

import java.util.concurrent.Semaphore;

public class MainEjercicio11Semaforos2 {

	public static void main(String[] args) {
		Semaphore finP1=new Semaphore(0);
		Semaphore finP2=new Semaphore(0);
		Semaphore finP3=new Semaphore(0);
		Semaphore finP4=new Semaphore(0);
		
		HiloP1 hiloP1=new HiloP1("Hilo1", finP1);
		HiloP2 hiloP2=new HiloP2("Hilo2", finP1, finP2);
		HiloP3 hiloP3=new HiloP3("Hilo3", finP1, finP3);
		HiloP4 hiloP4=new HiloP4("Hilo4", finP2, finP4);
		HiloP5 hiloP5=new HiloP5("Hilo5", finP2,finP3);
		HiloP6 hiloP6=new HiloP6("Hilo6", finP3, finP4);
		
		
		hiloP1.start();
		hiloP2.start();
		hiloP3.start();
		hiloP4.start();
		hiloP5.start();
		hiloP6.start();
		
		System.out.println("Se terminaron todos los hilos");

	}

}
