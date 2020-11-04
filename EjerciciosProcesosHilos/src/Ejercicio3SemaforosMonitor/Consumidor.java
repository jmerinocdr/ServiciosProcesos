package Ejercicio3SemaforosMonitor;


public class Consumidor extends Thread {
	Datos datos;
	public Consumidor(Datos datos) {
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
			System.out.println("Intento consumir");
			this.getDatos().consumirDatos();
		}
	}
}
