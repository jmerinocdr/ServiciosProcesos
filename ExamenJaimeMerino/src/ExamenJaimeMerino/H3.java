package ExamenJaimeMerino;

import java.util.concurrent.Semaphore;

public class H3 extends Thread{
	
	Semaphore finA2;
	Semaphore finA3;
	
	Semaphore finB2;
	Semaphore finB3;
	
	Semaphore finC3;
	
	Semaphore finD3;
	
	/**
	 * Creamos el hilo3
	 * @param string
	 * @param finA3
	 * @param finA2
	 * @param finB3
	 * @param finB2
	 * @param finC3
	 * @param finD3
	 */
	public H3(String string, Semaphore finA3, Semaphore finA2, Semaphore finB3, Semaphore finB2, Semaphore finC3,
			Semaphore finD3) {
		this.setName(string);
		this.setFinA3(finA3);
		this.setFinA2(finA2);
		this.setFinB2(finB2);
		this.setFinB3(finB3);
		this.setFinC3(finC3);
		this.setFinD3(finD3);
	}

	
	
	
	public Semaphore getFinA2() {
		return finA2;
	}




	public Semaphore getFinA3() {
		return finA3;
	}




	public Semaphore getFinB2() {
		return finB2;
	}




	public Semaphore getFinB3() {
		return finB3;
	}




	public Semaphore getFinC3() {
		return finC3;
	}




	public Semaphore getFinD3() {
		return finD3;
	}




	public void setFinA2(Semaphore finA2) {
		this.finA2 = finA2;
	}




	public void setFinA3(Semaphore finA3) {
		this.finA3 = finA3;
	}




	public void setFinB2(Semaphore finB2) {
		this.finB2 = finB2;
	}




	public void setFinB3(Semaphore finB3) {
		this.finB3 = finB3;
	}




	public void setFinC3(Semaphore finC3) {
		this.finC3 = finC3;
	}




	public void setFinD3(Semaphore finD3) {
		this.finD3 = finD3;
	}



	/**
	 * Ejecutamos el hilo 3
	 */
	public void run() {
		System.out.println(this.getName()+" Ejecuto A3"); //Se ejecuta A3
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinA3().release(); //Damos la señal de que se ha terminado A3
		
		this.getFinA2().acquireUninterruptibly(); //Esperamos a que termine A2
		System.out.println(this.getName()+" Ejecuto B3"); //Se ejecuta B3
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinB3().release(); //Damos la señal de que se ha terminado B3
		
		this.getFinB2().acquireUninterruptibly(); //Esperamos a que termine B2
		System.out.println(this.getName()+" Ejecuto C3"); //Se ejecuta C3
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinC3().release(); //Damos la señal de que se ha terminado C3
		
		System.out.println(this.getName()+" Ejecuto D3"); //Se ejecuta D3
		try {
			sleep((int)Math.floor(Math.random()*500+100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFinD3().release(); //Damos la señal de que se ha terminado D3
		System.out.println(this.getName()+" Fin");
	}
	
}
