package Ejercicio8Semaforos2;

import java.util.concurrent.Semaphore;

public class MainEjercicio8Semaforos2 {
	public static void main(String[] args) {
		Semaphore ordenp1p3=new Semaphore(1);
		Semaphore ordenp3p2=new Semaphore(0);
		Semaphore ordenp2p1=new Semaphore(0);
			
		Proceso proceso1=new Proceso(1, ordenp1p3, ordenp2p1);
		Proceso proceso2=new Proceso(2, ordenp2p1, ordenp3p2);
		Proceso proceso3=new Proceso(3, ordenp3p2, ordenp1p3);
		proceso1.start();
		proceso2.start();
		proceso3.start();
			
		
	}
}
