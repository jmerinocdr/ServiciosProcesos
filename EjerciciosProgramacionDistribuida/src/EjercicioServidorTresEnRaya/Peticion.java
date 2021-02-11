package EjercicioServidorTresEnRaya;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import EjercicioClienteTresEnRaya.Data;

public class Peticion implements Runnable{
	private String nombre;
	private String ip;
	private String[][] tabla;
	private Data data;
	private Socket sc;
	
	public Peticion(Socket sc) {
		this.sc=sc;
	}

	@Override
	public void run() {
		ObjectInputStream istream;
		try {
			istream = new ObjectInputStream(sc.getInputStream());
			data = (Data) istream.readObject();
			nombre=data.getNombre();
			ip=data.getIp();
			tabla=data.getTabla();
			System.out.println("Registrado "+nombre+" envía a "+ip+":"
					+ "\n"+tabla[0][0]+"|"+tabla[0][0]+"|"+tabla[0][0]
					+ "\n"+tabla[0][0]+"|"+tabla[0][0]+"|"+tabla[0][0]
					+ "\n"+tabla[0][0]+"|"+tabla[0][0]+"|"+tabla[0][0]
					+ "\n -----------------------------------------------");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
