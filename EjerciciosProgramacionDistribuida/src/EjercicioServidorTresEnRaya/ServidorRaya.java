package EjercicioServidorTresEnRaya;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorRaya{
	public static void main(String args[]) {
		
		
		try {
			ServerSocket ssc= new ServerSocket(2500);
			while(true) {
				Socket sc=ssc.accept();
				Peticion peticion = new Peticion(sc);
				peticion.run();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
