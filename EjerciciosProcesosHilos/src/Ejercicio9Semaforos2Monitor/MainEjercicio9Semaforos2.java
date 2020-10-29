package Ejercicio9Semaforos2Monitor;


public class MainEjercicio9Semaforos2 {

	public static void main(String[] args) {
		Balones[] balones=new Balones[8];
		for(int i=0; i<8; i++) {
			balones[i]=new Balones(Integer.toString(i));
		}
		for(int i=0; i<100; i++) {
			Partido partido=new Partido(i, balones);
			partido.start();
		}
		
	}

}
