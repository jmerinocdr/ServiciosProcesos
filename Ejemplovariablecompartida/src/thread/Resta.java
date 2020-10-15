package thread;

public class Resta extends Thread{
	
	Variable v2;
	private int num;
	
	public Resta(String str,Variable v) {
        super(str);
        v2=v;
    }
	public void run() {
        for (int i = 0; i < 100 ; i++) {
 
            num=v2.getx();
            num=num-1;
            v2.setx(num);
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
