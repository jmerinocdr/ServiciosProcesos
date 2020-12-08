package Ejercicio6Semaforos2;

import java.util.concurrent.Semaphore;

public class Enfermo extends Thread{
	private int nombre;
	
	private Semaphore smedico;
	private Semaphore sescayola;
	private Semaphore srayos;
	
	private Semaphore medico;
	private Semaphore escayola;
	private Semaphore rayos;
	
	private Enfermera enfermera;
	
	private Medico cmedico;
	private Escayola cescayola;
	private Rayos crayos;
	
	private String sala="";
	
	public Enfermo(int i, Semaphore smedico, Semaphore sescayola, Semaphore srayos, Semaphore medico, Semaphore escayola, Semaphore rayos, Enfermera enfermera, Medico cmedico, Escayola cescayola, Rayos crayos) {
		this.setNombre(i);
		
		this.setSmedico(smedico);
		this.setSescayola(sescayola);
		this.setSrayos(srayos);
		
		this.setMedico(medico);
		this.setEscayola(escayola);
		this.setRayos(rayos);
		
		this.setEnfermera(enfermera);
		
		this.setCmedico(cmedico);
		this.setCescayola(cescayola);
		this.setCrayos(crayos);
		
	}

	
	private int getNombre() {
		return nombre;
	}

	private Semaphore getSmedico() {
		return smedico;
	}

	private Semaphore getSescayola() {
		return sescayola;
	}

	private Semaphore getSrayos() {
		return srayos;
	}

	private Semaphore getMedico() {
		return medico;
	}

	private Semaphore getEscayola() {
		return escayola;
	}

	private Semaphore getRayos() {
		return rayos;
	}

	private Enfermera getEnfermera() {
		return enfermera;
	}

	private Medico getCmedico() {
		return cmedico;
	}

	private Escayola getCescayola() {
		return cescayola;
	}

	private Rayos getCrayos() {
		return crayos;
	}
	
	private String getSala() {
		return sala;
	}
	

	private void setNombre(int nombre) {
		this.nombre = nombre;
	}

	private void setSmedico(Semaphore smedico) {
		this.smedico = smedico;
	}

	private void setSescayola(Semaphore sescayola) {
		this.sescayola = sescayola;
	}

	private void setSrayos(Semaphore srayos) {
		this.srayos = srayos;
	}

	private void setMedico(Semaphore medico) {
		this.medico = medico;
	}

	private void setEscayola(Semaphore escayola) {
		this.escayola = escayola;
	}

	private void setRayos(Semaphore rayos) {
		this.rayos = rayos;
	}

	private void setEnfermera(Enfermera enfermera) {
		this.enfermera = enfermera;
	}

	private void setCmedico(Medico cmedico) {
		this.cmedico = cmedico;
	}

	private void setCescayola(Escayola cescayola) {
		this.cescayola = cescayola;
	}

	private void setCrayos(Rayos crayos) {
		this.crayos = crayos;
	}
	
	private void setSala(String sala) {
		this.sala = sala;
	}
	
	
	public void run() {
		this.setSala(this.getEnfermera().otorgarSala(this.getNombre()));
		
		
		if("Medico".equals(this.getSala())) {
			this.getSmedico().acquireUninterruptibly();
			System.out.println("Enfermo"+this.getNombre()+" - Entro en la sala de espera");
			this.getMedico().acquireUninterruptibly();
			this.getSmedico().release();
			System.out.println("Enfermo"+this.getNombre()+" - Entro en el médico y salgo de la sala de espera");
			this.getCmedico().usarMedico(this.getNombre());
			try {
				sleep(800+((long)Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getMedico().release();
			System.out.println("Enfermo"+this.getNombre()+" - Salgo del médico");
		}
		
		
		if("Rayos".equals(this.getSala())) {
			this.getSrayos().acquireUninterruptibly();
			System.out.println("Enfermo"+this.getNombre()+" - Entro en la sala de espera");
			this.getRayos().acquireUninterruptibly();
			this.getSrayos().release();
			System.out.println("Enfermo"+this.getNombre()+" - Entro en rayos y salgo de la sala de espera");
			this.getCrayos().usarRayos(this.getNombre());
			try {
				sleep(800+((long)Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getRayos().release();
			System.out.println("Enfermo"+this.getNombre()+" - Salgo de rayos");
		}
		
		
		if("Escayola".equals(this.getSala())) {
			this.getSescayola().acquireUninterruptibly();
			System.out.println("Enfermo"+this.getNombre()+" - Entro en la sala de espera");
			this.getEscayola().acquireUninterruptibly();
			this.getSescayola().release();
			System.out.println("Enfermo"+this.getNombre()+" - Entro en escayola y salgo de la sala de espera");
			this.getCescayola().usarEscayola(this.getNombre());
			try {
				sleep(800+((long)Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getEscayola().release();
			System.out.println("Enfermo"+this.getNombre()+" - Salgo de escayola");
		}
	}
	
	
}
