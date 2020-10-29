package Ejercicio9Semaforos2Monitor;

public class Balones {
	String name;
	boolean estado=false;
	public Balones(String name){
		this.setName(name);
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public synchronized void cogerBalon() {
		while(this.estado==true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.estado=true;
		System.out.println("Balon "+this.getName()+" se ha cogido");
		notifyAll();
	}
	public synchronized void soltarBalon() {
		while(this.estado==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.estado=false;
		System.out.println("Balon "+this.getName()+" se ha soltado");
		notifyAll();
	}
}
