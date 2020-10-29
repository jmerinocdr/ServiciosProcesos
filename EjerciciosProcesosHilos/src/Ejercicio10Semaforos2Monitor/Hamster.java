package Ejercicio10Semaforos2Monitor;


public class Hamster extends Thread{
	private int num;
	private Comida comida;
	private Rueda rueda;
	public Hamster(int num, Comida comida, Rueda rueda) {
		setNum(num);
		this.setComida(comida);
		this.setRueda(rueda);
	}
	
	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public void setRueda(Rueda rueda) {
		this.rueda = rueda;
	}

	public Comida getComida() {
		return comida;
	}

	public Rueda getRueda() {
		return rueda;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void run() {
		boolean eject=true;
		while(eject==true) {
			System.out.println("Hamster "+num+" intento comer");
			comida.empezarComer();
			System.out.println("Hamster "+num+" como");
			try {
				sleep(800+((long)Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comida.dejarComer();
			System.out.println("Hamster "+num+" dejo de comer");
			
			System.out.println("Hamster "+num+" intento ruedear");
			comida.empezarComer();
			System.out.println("Hamster "+num+" ruedeo");
			try {
				sleep(800+((long)Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comida.dejarComer();
			System.out.println("Hamster "+num+" dejo de ruedear");
		}
		
		
		
		/*
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
		*/
	}
	
	
}
