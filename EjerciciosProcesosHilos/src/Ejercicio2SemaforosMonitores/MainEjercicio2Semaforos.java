package Ejercicio2SemaforosMonitores;


public class MainEjercicio2Semaforos {

	public static void main(String[] args) {
		Datos datos=new Datos();
		Productor productor = new Productor(datos);
		Consumidor consumidor = new Consumidor(datos);

		
			productor.start();
			consumidor.start();
			
		

	}

}
