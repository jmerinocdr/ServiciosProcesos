package Ejercicio12Semaforos2;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread{
	Semaphore semaforoSilla;
	Semaphore semaforoSillas;
	Semaphore semaforoDespierto;
	public Cliente(int i, Semaphore semaforoSilla, Semaphore semaforoSillas, Semaphore semaforoDespierto) {
		this.setName(Integer.toString(i));
		this.setSemaforoSilla(semaforoSilla);
		this.setSemaforoSillas(semaforoSillas);
		this.setSemaforoDespierto(semaforoDespierto);
	}
	private void setSemaforoSillas(Semaphore semaforoSillas) {
		this.semaforoSillas = semaforoSillas;
	}
	private void setSemaforoSilla(Semaphore semaforoSilla) {
		this.semaforoSilla = semaforoSilla;
	}
	private void setSemaforoDespierto(Semaphore semaforoDespierto) {
		this.semaforoDespierto = semaforoDespierto;
	}

	public void run() {
			System.out.println("Cliente"+this.getName()+"- Intento acceder a la peluqueria");
				semaforoSillas.acquireUninterruptibly();
				System.out.println("Cliente"+this.getName()+"- He cogido una silla para la sala de espera");
				System.out.println("Cliente"+this.getName()+"Espero a que se libere la silla del corte");
				semaforoSilla.acquireUninterruptibly();
				semaforoDespierto.release();
				System.out.println("Cliente"+this.getName()+"- Cojo la silla de corte y despierto al peluquero");
				semaforoSillas.release();
				System.out.println("Cliente"+this.getName()+"- He liberado la silla de la sala de espera y me siento a cortar el pelo");
				try {
					sleep(800+((long)Math.random()*2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semaforoSilla.release();
			System.out.println("Cliente"+this.getName()+"- Me voy de la peluqueria");
	}
}
