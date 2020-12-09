package ExamenJaimeMerino;

import java.util.concurrent.Semaphore;


public class MainExamenJaimeMerino {

	public static void main(String[] args) {
		
		//Creamos los semáforos
		//Se han creado más semaforos de los necesarios por si en un futuro se quiere ampliar el programa
		Semaphore finA1=new Semaphore(0);
		Semaphore finA2=new Semaphore(0);
		Semaphore finA3=new Semaphore(0);
		
		Semaphore finB1=new Semaphore(0);
		Semaphore finB2=new Semaphore(0);
		Semaphore finB3=new Semaphore(0);
		
		Semaphore finC1=new Semaphore(0);
		Semaphore finC2=new Semaphore(0);
		Semaphore finC3=new Semaphore(0);
		
		Semaphore finD1=new Semaphore(0);
		Semaphore finD2=new Semaphore(0);
		Semaphore finD3=new Semaphore(0);
		
		//Creamos los hilos
		H1 h1=new H1("Hilo1", finA1, finB1, finB2, finC1, finD1);
		H2 h2=new H2("Hilo2", finA2, finA1, finB2, finC2, finC3, finD2);
		H3 h3=new H3("Hilo3", finA3, finA2, finB3, finB2, finC3, finD3);
		
		//Iniciamos los hilos
		h1.start();
		h2.start();
		h3.start();
		
		//Esperamos a que todos los hilos terminen
		finD1.acquireUninterruptibly();
		finD2.acquireUninterruptibly();
		finD3.acquireUninterruptibly();
		System.out.println("Se terminaron todos los hilos");
	}

}
