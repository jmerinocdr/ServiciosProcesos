package Ejercicio12Semaforos2;

import java.util.concurrent.Semaphore;

public class Peluquero extends Thread{
	Semaphore semaforoDespierto;
	public Peluquero(Semaphore semaforoDespierto) {
		this.setSemaforoDespierto(semaforoDespierto);
	}

	private void setSemaforoDespierto(Semaphore semaforoDespierto) {
		this.semaforoDespierto = semaforoDespierto;
	}

	public void run() {
		boolean eject=true;
		while(eject==true) {
			System.out.println("Peluquero- Intento cortar el pelo");
			semaforoDespierto.acquireUninterruptibly();
			System.out.println("Peluquero- Corto el pelo");
			try {
				sleep(800+((long)Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			semaforoDespierto.release();
			System.out.println("Peluquero- Duermo");
		}
	}
}
