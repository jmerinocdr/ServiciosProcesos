package thread;

import java.util.concurrent.Semaphore;

public class Suma extends Thread{
	
	Variable v2;
	private int num;
	private Semaphore S;
	
	public Suma(String str,Variable v, Semaphore S) {
        super(str);
        v2=v;
        this.S=S;
    }
	public void run() {
        for (int i = 0; i < 100 ; i++) {
        	S.acquireUninterruptibly();
            num=v2.getx();
            num=num+2;
            v2.setx(num);
            S.release();
            System.out.println("Hilo " + getName()+ "x: "+num);
            try{
            	
            	Thread.sleep(100);
            }
            catch(InterruptedException e){
            	//
            }
            }
        System.out.println("Termina thread " + getName());
    }
}
