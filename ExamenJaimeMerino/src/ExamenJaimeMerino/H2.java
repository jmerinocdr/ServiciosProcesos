package ExamenJaimeMerino;

import java.util.concurrent.Semaphore;

public class H2 extends Thread{
	
	Semaphore finA1;
	Semaphore finA2;
	
	Semaphore finB2;
	
	Semaphore finC2;
	Semaphore finC3;
	
	Semaphore finD2;
	
	/**
	 * Creamos el hilo2
	 * @param string
	 * @param finA2
	 * @param finA1
	 * @param finB2
	 * @param finC2
	 * @param finC3
	 * @param finD2
	 */
	public H2(String string, Semaphore finA2, Semaphore finA1, Semaphore finB2, Semaphore finC2, Semaphore finC3,
			Semaphore finD2) {
		this.setName(string);
		this.setFinA2(finA2);
		this.setFinA1(finA1);
		this.setFinB2(finB2);
		this.setFinC2(finC2);
		this.setFinC3(finC3);
		this.setFinD2(finD2);
	}
	
	

	public Semaphore getFinA1() {
		return finA1;
	}



	public Semaphore getFinA2() {
		return finA2;
	}



	public Semaphore getFinB2() {
		return finB2;
	}



	public Semaphore getFinC2() {
		return finC2;
	}



	public Semaphore getFinC3() {
		return finC3;
	}



	public Semaphore getFinD2() {
		return finD2;
	}



	public void setFinA1(Semaphore finA1) {
		this.finA1 = finA1;
	}



	public void setFinA2(Semaphore finA2) {
		this.finA2 = finA2;
	}



	public void setFinB2(Semaphore finB2) {
		this.finB2 = finB2;
	}



	public void setFinC2(Semaphore finC2) {
		this.finC2 = finC2;
	}



	public void setFinC3(Semaphore finC3) {
		this.finC3 = finC3;
	}



	public void setFinD2(Semaphore finD2) {
		this.finD2 = finD2;
	}


	/**
	 * Ejecutamos el hilo 2
	 */
	public void run() {
		//Ejecutamos A2
		System.out.println(this.getName()+" Ejecuto A2"); //Se ejecuta A2
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinA2().release(); //Damos la señal de que se ha terminado A2
		
		this.getFinA1().acquireUninterruptibly();//Esperamos a que termine A1
		System.out.println(this.getName()+" Ejecuto B2"); //Se ejecuta B2
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinB2().release(); //Damos la señal de que se ha terminado B2
		this.getFinB2().release(); //Damos la señal de que se ha terminado B2
		//Se introducen dos señales de fin B2 porque le estan esperando dos hilos
		
		System.out.println(this.getName()+" Ejecuto C2"); //Se ejecuta C2
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinC2().release(); //Damos la señal de que se ha terminado C2
		
		this.getFinC3().acquireUninterruptibly(); //Esperamos a que termine C3
		System.out.println(this.getName()+" Ejecuto D2"); //Se ejecuta D2
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinD2().release(); //Damos la señal de que se ha terminado D2
		System.out.println(this.getName()+" Fin");
	}
	
}