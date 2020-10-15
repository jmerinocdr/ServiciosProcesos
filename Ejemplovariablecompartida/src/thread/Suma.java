package thread;

public class Suma extends Thread{
	
	Variable v2;
	private int num;
	
	public Suma(String str,Variable v) {
        super(str);
        v2=v;
    }
	public void run() {
        for (int i = 0; i < 100 ; i++) {
            
            num=v2.getx();
            num=num+2;
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
