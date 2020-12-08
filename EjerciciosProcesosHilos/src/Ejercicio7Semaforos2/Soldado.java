package Ejercicio7Semaforos2;

import java.util.concurrent.Semaphore;

public class Soldado extends Thread{
	Semaphore cuartel=new Semaphore(500);
	Semaphore mostradores=new Semaphore(5);
	Semaphore abridores=new Semaphore(50);
	Semaphore postre=new Semaphore(3);
	
	public Soldado(int i, Semaphore cuartel, Semaphore mostradores, Semaphore abridores, Semaphore postre) {
		this.setName(Integer.toString(i));
		this.setCuartel(cuartel);
		this.setMostradores(mostradores);
		this.setAbridores(abridores);
		this.setPostre(postre);
	}

	private Semaphore getCuartel() {
		return cuartel;
	}

	private Semaphore getMostradores() {
		return mostradores;
	}

	private Semaphore getAbridores() {
		return abridores;
	}

	private Semaphore getPostre() {
		return postre;
	}

	private void setCuartel(Semaphore cuartel) {
		this.cuartel = cuartel;
	}

	private void setMostradores(Semaphore mostradores) {
		this.mostradores = mostradores;
	}

	private void setAbridores(Semaphore abridores) {
		this.abridores = abridores;
	}

	private void setPostre(Semaphore postre) {
		this.postre = postre;
	}
	
	public void run() {
		//boolean eject=true;
		//while(eject==true) {
			System.out.println("Soldado"+this.getName()+" - Intento comer");
			this.getCuartel().acquireUninterruptibly();
			System.out.println("Soldado"+this.getName()+" - Accedo al cuartel");
			this.getMostradores().acquireUninterruptibly();
			System.out.println("Soldado"+this.getName()+" - Accedo al mostrador");
			this.getMostradores().release();
			this.getAbridores().acquireUninterruptibly();
			System.out.println("Soldado"+this.getName()+" - Obtengo uno de los abridores");
			this.getAbridores().release();
			this.getPostre().acquireUninterruptibly();
			System.out.println("Soldado"+this.getName()+" - Obtengo el postre");
			this.getPostre().release();
			System.out.println("Soldado"+this.getName()+" - COMO");
			try {
				sleep(800+((long)Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getCuartel().release();
			System.out.println("Soldado"+this.getName()+" - He terminado de comer");
			
		//}
	}

}
