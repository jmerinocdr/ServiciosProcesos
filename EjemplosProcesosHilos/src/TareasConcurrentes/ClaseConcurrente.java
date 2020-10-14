package TareasConcurrentes;

public class ClaseConcurrente extends Thread{
	public void run() {
		for(int i=0; i<2000; i++) {
			System.out.println(this.getName()+":");
			System.out.println("El valor de i es: "+i);
		}
	}
}
