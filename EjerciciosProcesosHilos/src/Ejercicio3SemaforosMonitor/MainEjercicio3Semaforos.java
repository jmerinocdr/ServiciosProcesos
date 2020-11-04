package Ejercicio3SemaforosMonitor;


public class MainEjercicio3Semaforos {

	public static void main(String[] args) {
		Datos datos=new Datos();
		Productor productor =new Productor(datos);
		
		Consumidor consumidor1=new Consumidor(datos);
		Consumidor consumidor2=new Consumidor(datos);
		Consumidor consumidor3=new Consumidor(datos);
		
		productor.start();
		consumidor1.start();
		consumidor2.start();
		consumidor3.start();

	}
}
