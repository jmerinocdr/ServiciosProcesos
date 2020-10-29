package Ejercicio10Semaforos2Monitor;


public class MainEjercicio10Semaforos2 {
	public static void main(String[] args) {
		Comida comida=new Comida(3);
		Rueda rueda=new Rueda(1);
		for(int i=0; i<100; i++) {
			Hamster hamster=new Hamster(i, comida, rueda);
			hamster.start();
		}
		System.out.println("Terminaron todos los hamsters");
	}
}
