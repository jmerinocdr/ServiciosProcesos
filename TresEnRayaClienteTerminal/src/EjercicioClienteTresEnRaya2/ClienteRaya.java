package EjercicioClienteTresEnRaya2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;



public class ClienteRaya {

	private String Nombre;
	private String IP;
	private Tabla tabla = new Tabla();
	private String symb="O";
	private void setSymb(String symb) {
		this.symb = symb;
	}
	private String getSymb() {
		return this.symb;
	}
	

	public ClienteRaya() {
		
	}

	
	public void sendData() {
		System.out.println("Entramos al sendData");
		try {
			System.out.println("Creamos socket");
			sleep(1000);
			Socket sc=new Socket("Unknow-PC", 2500);
			System.out.println("Creamos data");
			sleep(1000);
			Data datos=new Data();
			System.out.println("Introducimos datos al data");
			sleep(1000);
			datos.setStr(getSymb());
			datos.setNombre(Nombre);
			datos.setIp(IP);
			datos.setTabla(tabla.getTabla());
			System.out.println("Generamos el ostream");
			sleep(1000);
			ObjectOutputStream ostream = new ObjectOutputStream(sc.getOutputStream());
			System.out.println("enviamos el ostream");
			sleep(1000);
			ostream.writeObject(datos);
			System.out.println("cerramos el socket");
			sleep(1000);
			sc.close();
		} catch (UnknownHostException e1) {
			System.out.println("--PROBLEMA CON EL HOST--");
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void setData(Data data) {
		String[][] stabla = data.getTabla();
		System.out.println("El symb vale "+getSymb()+" y data recibida vale "+data.getStr());
		if(data.getStr().equals("O")) {
			System.out.println("Symb es X porque recibió O");
			this.setSymb("X");
		}
		System.out.println("Tras procesar ...");
		System.out.println("El symb vale "+getSymb()+" y data recibida vale "+data.getStr());
		this.tabla.setTabla(stabla);
		System.out.println("Recibido "
				+ "\n"+stabla[0][0]+"|"+stabla[0][1]+"|"+stabla[0][2]
				+ "\n"+stabla[1][0]+"|"+stabla[1][1]+"|"+stabla[1][2]
				+ "\n"+stabla[2][0]+"|"+stabla[2][1]+"|"+stabla[2][2]
				+ "\n -----------------------------------------------");
	}
	public void verTabla() {
		System.out.println("Recibido "
				+ "\n"+this.tabla.getTabla()[0][0]+"|"+this.tabla.getTabla()[0][1]+"|"+this.tabla.getTabla()[0][2]
				+ "\n"+this.tabla.getTabla()[1][0]+"|"+this.tabla.getTabla()[1][1]+"|"+this.tabla.getTabla()[1][2]
				+ "\n"+this.tabla.getTabla()[2][0]+"|"+this.tabla.getTabla()[2][1]+"|"+this.tabla.getTabla()[2][2]
				+ "\n -----------------------------------------------");
	}
	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setNombre(String nextLine) {
		this.Nombre=nextLine;
		
	}
	public void setIp(String nextLine) {
		this.IP=nextLine;
		
	}
	public void anadirTabla(int x, int y, String symb2) {
		this.tabla.anadirTabla(x, y, symb2);
		
	}

}




