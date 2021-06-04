package EjercicioServidorCuentaCaracteresStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCuentaCaracteresStream {

	public static void main(String[] args) {
		
		ServerSocket serverAddr = null;
		Socket sc = null;
		String cadenaRecibida ; // petición
		String caracteres = null;
		try {
			serverAddr = new ServerSocket(2500);
		}
		catch (Exception e){
			System.err.println("Error creando socket");
		}
		while (true){
			try {
				sc = serverAddr.accept(); // esperando conexión
				InputStream istream = sc.getInputStream();
				ObjectInput in = new ObjectInputStream(istream);
				cadenaRecibida = (String) in.readObject();
				
				
				caracteres = String.valueOf(caracteres.length());
				
				
				DataOutputStream ostream = new DataOutputStream(sc.getOutputStream());
				ostream.writeUTF(caracteres);
				ostream.flush();
				sc.close();
			}
			catch(Exception e) {
				System.err.println("excepcion " + e.toString() );
				e.printStackTrace() ;
			}
		}
	}
}
