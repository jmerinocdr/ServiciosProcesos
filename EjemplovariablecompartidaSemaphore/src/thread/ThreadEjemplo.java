package thread;
import java.util.concurrent.*;
public class ThreadEjemplo  {
   
	
	
    
    public static void main (String [] args) throws InterruptedException{
    	Semaphore S=new Semaphore(1);
    	Variable v=new Variable();
        Suma s=new Suma("Suma",v,S);
        s.start();
        Resta r=new Resta("Resta",v,S);
        r.start();
        s.join();
        r.join();

        System.out.println("Termina thread main: "+v.getx());
           }
}
