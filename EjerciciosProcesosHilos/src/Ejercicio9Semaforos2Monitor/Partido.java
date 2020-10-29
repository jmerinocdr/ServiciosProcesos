package Ejercicio9Semaforos2Monitor;


public class Partido extends Thread{
	private int num;
	private Balones[] balones;
	private int random;
	public Partido(int num, Balones[] balones) {
		this.setNum(num);
		this.setBalones(balones);
	}
	
	
	public Balones[] getBalones() {
		return balones;
	}
	
	public void setBalones(Balones[] balones) {
		this.balones = balones;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void run() {
		random=(int) Math.floor(Math.random()*8+1);
		System.out.println(num+" Intento obtener el balón " + random);
		balones[random].cogerBalon();
		System.out.println("Partido "+this.getNum()+" He obtenido un balón "+random);
		System.out.println("Juego el partido");
		try {
			sleep(800+((long)Math.random()*2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		balones[random].soltarBalon();
		
	}
	
	
}
