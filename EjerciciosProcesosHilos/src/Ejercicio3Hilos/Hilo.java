package Ejercicio3Hilos;

public class Hilo extends Thread{
	private int thiscont;
	private int nextcont;
	public Hilo (String str, int cont) {
		super(str);
		this.thiscont=cont;
		System.out.println("Creacion hilo "+str+cont);
	}
	public void run() {
		nextcont=thiscont+1;
		if(thiscont<5) {
			Hilo subHilo=new Hilo("Hilo", nextcont);
			subHilo.start();
			try {
				sleep((long)(Math.random()*(601 - 100))+100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				subHilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Fin"+getName()+thiscont);
			thiscont=5;
		}
		
		else{
			System.out.println("Se ha llegado al máximo número de hilos");
		}
		
	}
}
