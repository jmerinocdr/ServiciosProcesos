package ExamenJaimeMerino;

import java.util.concurrent.Semaphore;

public class H1 extends Thread{
	
	Semaphore finA1;
	
	Semaphore finB1;
	Semaphore finB2;
	
	Semaphore finC1;
	
	Semaphore finD1;
	
	/**
	 * Creamos el hilo1
	 * @param string
	 * @param finA1
	 * @param finB1
	 * @param finB2
	 * @param finC1
	 * @param finD1
	 */
	public H1(String string, Semaphore finA1, Semaphore finB1, Semaphore finB2, Semaphore finC1, Semaphore finD1) {
		this.setName(string);
		this.setFinA1(finA1);
		this.setFinB1(finB1);
		this.setFinB2(finB2);
		this.setFinC1(finC1);
		this.setFinD1(finD1);
	}

	
	
	public Semaphore getFinA1() {
		return finA1;
	}



	public Semaphore getFinB1() {
		return finB1;
	}



	public Semaphore getFinB2() {
		return finB2;
	}



	public Semaphore getFinC1() {
		return finC1;
	}



	public Semaphore getFinD1() {
		return finD1;
	}



	public void setFinA1(Semaphore finA1) {
		this.finA1 = finA1;
	}



	public void setFinB1(Semaphore finB1) {
		this.finB1 = finB1;
	}



	public void setFinB2(Semaphore finB2) {
		this.finB2 = finB2;
	}



	public void setFinC1(Semaphore finC1) {
		this.finC1 = finC1;
	}



	public void setFinD1(Semaphore finD1) {
		this.finD1 = finD1;
	}



	/**
	 * Ejecutamos el hilo 1
	 */
	public void run() {
		
		System.out.println(this.getName()+" Ejecuto A1"); //Se ejecuta A1
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinA1().release(); //Damos la señal de que se ha terminado A1
		
		
		System.out.println(this.getName()+" Ejecuto B1"); //Se ejecuta B1
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinB1().release(); //Damos la señal de que se ha terminado B1
		
		this.getFinB2().acquireUninterruptibly(); //Esperamos a que termine B2
		System.out.println(this.getName()+" Ejecuto C1"); //Se ejecuta C1
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinC1().release(); //Damos la señal de que se ha terminado C1
		
		System.out.println(this.getName()+" Ejecuto D1"); //Se ejecuta D1
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinD1().release(); //Damos la señal de que se ha terminado D1
		System.out.println(this.getName()+" Fin");
		
	}
	
}
