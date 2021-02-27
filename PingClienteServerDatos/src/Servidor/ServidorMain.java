package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain {

	public static void main(String[] args) {
		String ping = "Servidor";
		
		ServerSocket ssc = null;
		Socket sc = null;
		ObjectInputStream istream = null;
		ObjectOutputStream ostream = null;
		
		try {
			ssc = new ServerSocket(26000);
			System.out.println("Servidor iniciado");
			while(true) {
				sc = ssc.accept();
				Thread peticion = new Thread(new Peticion(sc));
				peticion.start();
			}
		} catch (IOException e) {
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
