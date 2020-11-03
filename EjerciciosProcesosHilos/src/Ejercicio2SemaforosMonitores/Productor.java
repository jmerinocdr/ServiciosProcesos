package Ejercicio2SemaforosMonitores;


public class Productor extends Thread {
	Datos datos;
	public Productor(Datos datos) {
		this.setDatos(datos);
	}

	private Datos getDatos() {
		return datos;
	}

	private void setDatos(Datos datos) {
		this.datos = datos;
	}

	public void run() {
		boolean eject=true;
		while(eject==true) {
			System.out.println("Intento producir");
			this.getDatos().crearDatos();
		}
		
	}

}
