package Ejercicio4SemaforosMonitor;

public class Filosofo {
	private String nombre="";
	private Palillo[] palillos;
	public Filosofo(int nombre, Palillo[] palillos) {
		this.setNombre(Integer.toString(nombre));
		this.setPalillos(palillos);
	}
	
	private String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	private Palillo[] getPalillos() {
//		return palillos;
//	}
	private void setPalillos(Palillo[] palillos) {
		this.palillos = palillos;
	}

	public void run() {
		/**
		 * piensa 
		 */
		System.out.println("Filosofo"+this.getNombre()+" - Pienso...");
		/*
		 * coge palillo de derecha
		 */
		palillos[(Integer.parseInt(this.getNombre()))].cogerPalillo();
		System.out.println("Filosofo"+this.getNombre()+" - Cojo el palillo de la derecha");
		/*
		 * coge palillo de izquierda
		 */
		if(Integer.parseInt(this.getNombre())==palillos.length-1){
			palillos[0].cogerPalillo();
		}
		else {
			palillos[(Integer.parseInt(this.getNombre())+1)].cogerPalillo();
		}
		System.out.println("Filosofo"+this.getNombre()+" - Cojo el palillo de la izquierda");
		/*
		 * come
		 */
		System.out.println("Filosofo"+this.getNombre()+" - Como");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * libera palillo derecha
		 */
		System.out.println("Filosofo"+this.getNombre()+" - Libero palillo derecha");
		palillos[(Integer.parseInt(this.getNombre()))].liberarPalillo();

		/*
		 * libera palillo izquierda
		 **/
		System.out.println("Filosofo"+this.getNombre()+" - Libero palillo izquierda");
		if(Integer.parseInt(this.getNombre())==palillos.length-1){
			palillos[0].liberarPalillo();
		}
		else {
			palillos[(Integer.parseInt(this.getNombre())+1)].liberarPalillo();
		}
	}
}
