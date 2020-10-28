package Ejercicio4Semaforos;

public class Palillo {
	private int name;
	private boolean usado=false;
	
	public Palillo(int name) {
		this.setName(name);
		System.out.println("Palillo"+this.getName()+" creado");
	}
	
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public void usar(){
		this.setUsado(true);
		System.out.println("Palillo"+this.getName()+" Se está usando");
	}
	
	public void dejarUsar() {
		this.setUsado(false);
		System.out.println("Palillo"+this.getName()+" Se ha dejado de usar");
	}
	
}
