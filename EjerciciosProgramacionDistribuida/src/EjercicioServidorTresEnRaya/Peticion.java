package EjercicioServidorTresEnRaya;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
					+ "\n"+tabla[0][0]+"|"+tabla[0][1]+"|"+tabla[0][2]
					+ "\n"+tabla[1][0]+"|"+tabla[1][1]+"|"+tabla[1][2]
					+ "\n"+tabla[2][0]+"|"+tabla[2][1]+"|"+tabla[2][2]
					+ "\n -----------------------------------------------");
			Socket sco=new Socket(ip, 2600);
			ObjectOutputStream ostream=new ObjectOutputStream(sco.getOutputStream());
			ostream.writeObject(data);
			sco.close();
			sc.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
