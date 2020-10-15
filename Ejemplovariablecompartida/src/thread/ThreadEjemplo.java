package thread;

public class ThreadEjemplo  {
   
	
	
    
    public static void main (String [] args) throws InterruptedException{
    	
    	Variable v=new Variable();
        Suma s=new Suma("Suma",v);
        s.start();
        Resta r=new Resta("Resta",v);
        r.start();
        s.join();
        r.join();

        System.out.println("Termina thread main: "+v.getx());
           }
}
