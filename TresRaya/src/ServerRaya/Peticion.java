package ServerRaya;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Peticion implements Runnable{
	private String name;
	private String serverip;
	private String playerip;
	private String[][] tabla; 
	private int turno=0;
	Socket sc;
	
	
	public Peticion(Socket sc) {
		this.sc=sc;
	}

	@Override
	public void run() {
		ObjectInputStream istream;
		try {
			istream = new ObjectInputStream(sc.getInputStream());
			Data data = (Data) istream.readObject();
			name=data.getName();
			playerip=data.getPlayerip();
			tabla=data.getTabla();
			
			Socket sco=new Socket(playerip, 2600);
			ObjectOutputStream ostream=new ObjectOutputStream(sco.getOutputStream());
			ostream.writeObject(data);
			sco.close();
			sc.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			istream = new ObjectInputStream(sc.getInputStream());
			String[] ping = (String[]) istream.readObject();
			
			Socket sco=new Socket(playerip, 2600);
			ObjectOutputStream ostream=new ObjectOutputStream(sco.getOutputStream());
			ostream.writeObject(ping);
			sco.close();
			sc.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
