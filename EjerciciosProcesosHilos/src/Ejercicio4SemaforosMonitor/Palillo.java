package Ejercicio4SemaforosMonitor;

public class Palillo {
	private String nombre="";
	boolean libre=true;
	public Palillo() {
		
	}
	public Palillo(int nombre) {
		 this.setNombre(Integer.toString(nombre));
	}
	
	private String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public synchronized void cogerPalillo() {
		while(this.libre==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.libre=false;
		System.out.println("Palillo"+this.getNombre()+" - Cogido");
		notifyAll();
	}
	
	public synchronized void liberarPalillo() {
		while(this.libre==true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.libre=true;
		System.out.println("Palillo"+this.getNombre()+" - Liberado");
		notifyAll();
	}
	
	
}
