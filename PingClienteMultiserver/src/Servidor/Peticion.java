package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Peticion implements Runnable{
	Socket sc = null;
	ObjectInputStream istream;
	ObjectOutputStream ostream;
	String ping;
	
	public Peticion(Socket sc, ObjectInputStream istream, ObjectOutputStream ostream, String ping ) {
		this.sc=sc;
		this.istream=istream;
		this.ostream=ostream;
		this.ping=ping;
	}

	@Override
	public void run() {
		try {
			System.out.println("Cliente conectado");
			istream = new ObjectInputStream(sc.getInputStream());
			ostream = new ObjectOutputStream(sc.getOutputStream());
			String recibido = (String) istream.readObject();
			System.out.println("Se ha recibido ping "+recibido);
			ostream.writeObject(ping);
			sc.close();
			System.out.println("Cliente desconectado");
		}
		catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
