package Ejercicio9Semaforos2;

import java.util.concurrent.Semaphore;

public class Partido extends Thread{
	private int num;
	private Semaphore S;
	public Partido(int num, Semaphore S) {
		this.setNum(num);
		this.setS(S);
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public Semaphore getS() {
		return S;
	}

	public void setS(Semaphore s) {
		S = s;
	}

	public void run() {
		System.out.println(num+" Intento obtener un balón");
		try {
			S.acquire();
			System.out.println(num+" Empiezo el partido");
			sleep(800+((long)Math.random()*2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num+" Termino el partido");
		S.release();
		System.out.print(num+" He devuelto el balón");
		
	}
	
	
}
