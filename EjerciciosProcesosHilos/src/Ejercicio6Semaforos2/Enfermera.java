package Ejercicio6Semaforos2;

public class Enfermera {
	public Enfermera() {
		
	}
	public String otorgarSala(int i) {
		int random=(int)Math.floor(Math.random()*15+1);
		if(random<=5) {
			System.out.println("Enfermera otorga Medico a enfermo "+i);
			return "Medico";
		}
		else if(random>=10) {
			System.out.println("Enfermera otorga Rayos a enfermo "+i);
			return "Rayos";
		}
		else {
			System.out.println("Enfermera otorga Escayola a enfermo "+i);
			return "Escayola";
		}
	}
}
