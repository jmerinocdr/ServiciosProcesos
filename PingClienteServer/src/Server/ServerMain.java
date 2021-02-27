package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		String ping = "Servidor";
		
		ServerSocket ssc = null;
		Socket sc = null;
		ObjectInputStream istream;
		ObjectOutputStream ostream;
		
		try {
			ssc = new ServerSocket(26000);
			System.out.println("Servidor iniciado");
			while(true) {
				sc = ssc.accept();
				System.out.println("Cliente conectado");
				istream = new ObjectInputStream(sc.getInputStream());
				ostream = new ObjectOutputStream(sc.getOutputStream());
				String recibido = (String) istream.readObject();
				System.out.println("Se ha recibido ping "+recibido);
				ostream.writeObject(ping);
				sc.close();
				System.out.println("Cliente desconectado");
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
