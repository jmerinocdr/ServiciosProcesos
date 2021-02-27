package EjercicioClienteTresEnRaya;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Escucha implements Runnable {

	public void run(ClienteRaya window) {
		ServerSocket ss;
		try {
			ss = new ServerSocket(2600);
		Socket cliente;
		Data data = new Data();
		
		while(true) {
			
				cliente=ss.accept();
				System.out.println("Hilo escucha: recibo datos");
				ObjectInputStream istream=new ObjectInputStream(cliente.getInputStream());
				data = (Data) istream.readObject();
				window.setData(data);
			
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}
