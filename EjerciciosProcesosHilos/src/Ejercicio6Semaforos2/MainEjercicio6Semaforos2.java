package Ejercicio6Semaforos2;

import java.util.concurrent.Semaphore;

public class MainEjercicio6Semaforos2 {
	public static void main(String args[]) {
		
		Semaphore smedico=new Semaphore(20);
		Semaphore sescayola=new Semaphore(6);
		Semaphore srayos=new Semaphore(1);
		
		Semaphore medico=new Semaphore(1);
		Semaphore escayola=new Semaphore(1);
		Semaphore rayos=new Semaphore(1);
		
		Enfermera enfermera=new Enfermera();
		
		Medico cmedico=new Medico();
		Escayola cescayola=new Escayola();
		Rayos crayos=new Rayos();
		
		for(int i=0; i<100; i++) {
			Enfermo enfermo=new Enfermo(i, smedico, sescayola, srayos, medico, escayola, rayos, enfermera, cmedico, cescayola, crayos);
			enfermo.start();
		}
	}
}
