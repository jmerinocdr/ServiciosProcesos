package EjemploRunnableInterfaz;

public class Hilo implements Runnable{
	Thread hilo;

	public void start(){
	     if(hilo==null){
	        hilo=new Thread(this);
	        hilo.start();
	     }
	  }
	
	@Override
	public void run() {
		while (true) {
	        try{
	            Thread.sleep(100);
	        }catch (InterruptedException e) { }
	       //tareas a realizar...
	    }
	}
	
	public void stop(){
	     if(hilo!=null){
	        hilo.stop();
	        hilo=null;
	     }
	  }
}
