package Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteMain {

	public static void main(String[] args) {
		String ping = "Cliente";
		boolean eject = true;
		try {
			Socket sc = new Socket("Unknow-PC", 26000);
			ObjectOutputStream ostream = new ObjectOutputStream(sc.getOutputStream());
			ObjectInputStream istream = new ObjectInputStream(sc.getInputStream());
				ostream.writeObject(ping);
				String recibido = (String) istream.readObject();
				System.out.println("Se ha recibido ping "+recibido);
			sc.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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