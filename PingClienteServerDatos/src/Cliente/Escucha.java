package Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Servidor.Data;
public class Escucha implements Runnable {
	ClienteMain cliente;
	int puertoorigen;
	Data data = new Data();
	public Escucha() {
		
	}
	public Escucha(ClienteMain cliente) {
		this.cliente=cliente;
		this.puertoorigen=cliente.getPuertoorigen();
	}
	
	@Override
	public void run() {
		ServerSocket ssc;
		
			try {
				ssc = new ServerSocket(puertoorigen);
				Socket sc;
				
				while(true) {
					sc = ssc.accept();
					ObjectInputStream istream = new ObjectInputStream(sc.getInputStream());
					data = (Data) istream.readObject();
					cliente.procesarDatos(data);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
