package Cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import Servidor.Data;

public class ClienteMain {
	String ping; 
	Scanner teclado; 
	String ipdestino; 
	int puertodestino; 
	String iporigen; 
	int puertoorigen;
	String mensaje;
	Data data;
	public ClienteMain(String ping, Scanner teclado, String ipdestino, int puertodestino, String iporigen, int puertoorigen) {
		this.setPing(ping);
		this.setTeclado(teclado);
		this.setIpdestino(ipdestino);
		this.setPuertodestino(puertodestino);
		this.setIporigen(iporigen);
		this.setPuertoorigen(puertoorigen);
		
		data=new Data(iporigen, puertoorigen, ipdestino, puertodestino, mensaje);
	}

	public static void main(String[] args) {
		
		String ping = "Cliente";
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce la ip de la persona con la que quieres hablar: ");
		String ipdestinot = teclado.nextLine();
		System.out.println("Introduce el puerto de escucha del destinatario");
		int puertodestinot = teclado.nextInt(); teclado.nextLine();
		String iporigen = null;
		try {
			iporigen = (InetAddress.getLocalHost().getHostAddress()).trim();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Introduce el puerto de escucha con el que quieres recibir los datos");
		int puertoorigent = teclado.nextInt(); teclado.nextLine();
		ClienteMain cliente=new ClienteMain(ping, teclado, ipdestinot, puertodestinot, iporigen, puertoorigent);
		Thread escucha = new Thread(new Escucha(cliente));
		System.out.println("inicia la escucha");
		escucha.start();
		System.out.println("inicia el cliente");
		cliente.Start();
		

	}
	public void Start() {
		try {
			while(true) {
				Socket sc = new Socket("Unknow-PC", 26000);
				System.out.println("Introduce mensaje a enviar");
				this.setMensaje(teclado.nextLine());
				ObjectOutputStream ostream = new ObjectOutputStream(sc.getOutputStream());
				this.setMensajeData();
				ostream.writeObject(this.getData());
				sc.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setMensajeData() {
		this.data.setMensaje(this.getMensaje());
	}

	public void procesarDatos(Data data) {
		System.out.println(data.getMensaje());
	}
	
	public String getPing() {
		return ping;
	}

	public Scanner getTeclado() {
		return teclado;
	}

	public String getIpdestino() {
		return ipdestino;
	}

	public int getPuertodestino() {
		return puertodestino;
	}

	public String getIporigen() {
		return iporigen;
	}

	public int getPuertoorigen() {
		return puertoorigen;
	}

	private void setPing(String ping) {
		this.ping = ping;
	}
	
	private Data getData() {
		return data;
	}

	private void setData(Data data) {
		this.data = data;
	}

	public String getMensaje() {
		return mensaje;
	}

	private void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	private void setTeclado(Scanner teclado) {
		this.teclado = teclado;
	}

	private void setIpdestino(String ipdestino) {
		this.ipdestino = ipdestino;
	}

	private void setPuertodestino(int puertodestino) {
		this.puertodestino = puertodestino;
	}

	private void setIporigen(String iporigen) {
		this.iporigen = iporigen;
	}

	private void setPuertoorigen(int puertoorigen) {
		this.puertoorigen = puertoorigen;
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