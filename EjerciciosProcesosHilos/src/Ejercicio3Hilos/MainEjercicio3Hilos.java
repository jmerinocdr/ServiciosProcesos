package Ejercicio3Hilos;

public class MainEjercicio3Hilos {
	public static void main(String[] args) {
		Hilo HiloP=new Hilo("Hilo", 0);
		HiloP.start();
		try {
			HiloP.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Se termina el HiloP");
	}
}
