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
	Data data;
	
	public Peticion(Socket sc ) {
		this.sc=sc;
	}

	@Override
	public void run() {
		try {
			System.out.println("Cliente conectado");
			istream = new ObjectInputStream(sc.getInputStream());
			
			data = (Data) istream.readObject();
			System.out.println("Se ha recibido un paquete de datos");
			System.out.println("Desde "+data.getIporigen()+" con puerto "+data.getPuertoorigen());
			System.out.println("Para "+data.getIpdestino()+" con puerto "+data.getPuertodestino());
			System.out.println("Incluye "+data.getMensaje());
			String ipdestino = data.getIpdestino();
			int puertodestino = data.getPuertodestino();
			Socket sco = new Socket(ipdestino, puertodestino);
			ostream = new ObjectOutputStream(sco.getOutputStream());
			ostream.writeObject(data);
			sc.close();
			sco.close();
			System.out.println("Cliente desconectado");
		}
		catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
