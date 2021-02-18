package EjercicioClienteTresEnRaya2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Escucha extends ClienteRaya implements Runnable {

	@Override
	public void run() {
		ServerSocket ss;
		try {
			ss = new ServerSocket(2600);
		Socket cliente;
		Data data = new Data();
		
		while(true) {
			
				cliente=ss.accept();
				ObjectInputStream istream=new ObjectInputStream(cliente.getInputStream());
				data = (Data) istream.readObject();
				this.setData(data);
			
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
