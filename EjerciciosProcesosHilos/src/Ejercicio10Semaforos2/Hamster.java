package Ejercicio10Semaforos2;

import java.util.concurrent.Semaphore;

public class Hamster extends Thread{
	private int num;
	private Semaphore comida;
	private Semaphore rueda;
	public Hamster(int num, Semaphore comida, Semaphore rueda) {
		setNum(num);
		setComida(comida);
		setRueda(rueda);
	}
	
	public Semaphore getComida() {
		return comida;
	}

	public Semaphore getRueda() {
		return rueda;
	}

	public void setComida(Semaphore comida) {
		this.comida = comida;
	}

	public void setRueda(Semaphore rueda) {
		this.rueda = rueda;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void run() {
		System.out.println("Hamster "+num+" intento comer");
		try {
			comida.acquireUninterruptibly();
			System.out.println("Hamster "+num+" estoy comiendo");
			sleep(800+((long)Math.random()*2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hamster "+num+" termino de comer");
		comida.release();
		System.out.println("Hamster "+num+" me alejo del plato");
		
		
		System.out.println("Hamster "+num+" intento subir a la rueda");
		try {
			comida.acquireUninterruptibly();
			System.out.println("Hamster "+num+" he subido a la rueda");
			sleep(800+((long)Math.random()*2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hamster "+num+" termino de correr en la rueda");
		comida.release();
		System.out.println("Hamster "+num+" salgo de la rueda");
	}
	
	
}
