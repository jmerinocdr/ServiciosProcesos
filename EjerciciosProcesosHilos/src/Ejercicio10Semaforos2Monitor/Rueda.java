package Ejercicio10Semaforos2Monitor;

public class Rueda {
	private int valor;
	private int valort;
	public Rueda(int valor) {
		this.setValor(valor);
		this.setValort(valor);
	}
	
	
	public int getValort() {
		return valort;
	}

	public void setValort(int valort) {
		this.valort = valort;
	}

	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public synchronized void empezarComer() {
		while(valor<=0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Se ha empezado a rodar "+this.getValor());
		this.setValor(this.getValor()-1);
	}
	public synchronized void dejarComer() {
		this.setValor(this.getValor()+1);
		System.out.println("Se ha dejado de rodar "+this.getValor());
		notifyAll();
	}
}
