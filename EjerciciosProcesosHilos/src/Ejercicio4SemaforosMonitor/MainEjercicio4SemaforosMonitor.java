package Ejercicio4SemaforosMonitor;

public class MainEjercicio4SemaforosMonitor {

	public static void main(String[] args) {
		Palillo[] palillos=new Palillo[5];
		for(int i=0; i<5; i++) {
			palillos[i]=new Palillo(i);
		}
		
		for(int i=0; i<5; i++) {
			Filosofo filosofo=new Filosofo(i, palillos);
			filosofo.run();
		}
	}

}
