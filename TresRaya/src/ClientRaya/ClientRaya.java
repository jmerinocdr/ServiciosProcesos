package ClientRaya;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRaya {
	private String name;
	private String serverip;
	private String playerip;
	private String[][] tabla; 
	private int turno=0;

	public ClientRaya(String name, String serverip, String playerip) {
		this.setName(name);
		this.setServerip(serverip);
		this.setPlayerip(playerip);
	}

	private String getName() {
		return name;
	}

	private String getServerip() {
		return serverip;
	}

	private String getPlayerip() {
		return playerip;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setServerip(String serverip) {
		this.serverip = serverip;
	}

	private void setPlayerip(String playerip) {
		this.playerip = playerip;
	}

	public String[][] getTabla() {
		return tabla;
	}

	public void setTabla(String[][] tabla) {
		this.tabla = tabla;
	}
	
	public void setTabla(int x, int y, String symb) {
		this.getTabla()[x][y]=symb;
	}
	
	
	
	public int getTurno() {
		return turno;
	}

	private void setTurno(int turno) {
		this.turno = turno;
	}

	public void printTabla() {
		System.out.println( "|"+this.getTabla()[0][0]+"|"+this.getTabla()[0][1]+"|"+this.getTabla()[0][2]+"|"+
							"|"+this.getTabla()[1][0]+"|"+this.getTabla()[1][1]+"|"+this.getTabla()[1][2]+"|"+
							"|"+this.getTabla()[2][0]+"|"+this.getTabla()[2][1]+"|"+this.getTabla()[2][2]+"|");
	}
	public void sendPing() {
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			String ip = localhost.getHostAddress().trim();
			String[] ping = new String[3];
			ping[0] = this.getServerip();
			ping[1] = ip;
			ping[2] = this.getPlayerip();
			
			try {
				Socket sc=new Socket(serverip, 2500);
				ObjectOutputStream ostream = new ObjectOutputStream(sc.getOutputStream());
				ostream.writeObject(ping);
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ServerSocket ssc=new ServerSocket(2600);
			Socket sc=ssc.accept();
			ObjectInputStream istream=new ObjectInputStream(sc.getInputStream());
			this.setTurno(istream.readInt());
			ssc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Método para enviar los datos del cliente
	public void envia() {
		Data data=new Data(this.getName(), this.getServerip(), this.getPlayerip(), this.getTabla());
		try {
			Socket sc=new Socket(serverip, 2500);
			ObjectOutputStream ostream = new ObjectOutputStream(sc.getOutputStream());
			ostream.writeObject(data);
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Método para recibir los datos del servidor
	public void recibe() {
		try {
			ServerSocket ssc=new ServerSocket(2600);
			Socket sc=ssc.accept();
			ObjectInputStream istream=new ObjectInputStream(sc.getInputStream());
			Data data;
			try {
				data = (Data) istream.readObject();
				this.setTabla(data.getTabla());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ssc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
