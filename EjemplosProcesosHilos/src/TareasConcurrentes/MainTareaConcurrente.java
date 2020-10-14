package TareasConcurrentes;

public class MainTareaConcurrente {

	public static void main(String[] args) {
		ClaseConcurrente tarea1 = new ClaseConcurrente();
		ClaseConcurrente tarea2 = new ClaseConcurrente();
		
		tarea1.start();
		tarea2.start();
	}

}
