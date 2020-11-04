package Ejercicio3SemaforosMonitor;

public class Datos {
	int[] array = { 0, 0, 0, 0, 0 };
	int cont=0;
	public Datos() {
		
	}
	public synchronized void crearDatos() {
		array[cont]=(int)Math.floor(Math.random()*(9-1+1)+1);
		System.out.println("Se le ha asignado a "+cont+" el valor "+array[cont]);
		if(cont>=0 && cont<4) {
			cont++;
		}
	}
	public synchronized int consumirDatos() {
		int random=(int)Math.floor(Math.random()*(cont-1+1)+1);
		if(cont>0 && cont<=4) {
			cont--;
		}
		System.out.println("Se ha consumido el valor "+array[random]);
		return array[random];
	}
}
