package Ejercicio1Semaforos;

import java.util.concurrent.Semaphore;

public class MainEjercicio1Semaforos {

	public static void main(String[] args) {
		Semaphore scontador=new Semaphore(1);
		Contador contador=new Contador();
		Sensor sensor1=new Sensor(scontador, 1, contador);
		Sensor sensor2=new Sensor(scontador, 2, contador);
		
			sensor1.start();
			sensor2.start();
			
		System.out.println("Contador FINAL contiene "+contador.getContador());

	}

}
