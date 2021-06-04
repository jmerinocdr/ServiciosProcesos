package EjercicioClienteCuentaCaracteresStream;

import java.io.DataInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCuentaCaracteresStream {

	public static void main(String[] args) {
			String host="";
			String cadenaEnviar="";
			
			Scanner teclado = new Scanner (System.in);
			System.out.println("Introduce el host: ");
			host = teclado.nextLine ();
			System.out.println("Introduce una palabra para contar ");
			cadenaEnviar = teclado.nextLine ();
			teclado.close();
			
			String res="";
			try {
				// se crea la conexión
				Socket sc = new Socket(host, 2500); // conexión
				OutputStream ostream = sc.getOutputStream();
				ObjectOutput s = new ObjectOutputStream(ostream);
				DataInputStream istream = new DataInputStream(sc.getInputStream());
				s.writeObject(cadenaEnviar);
				s.flush();
				res = istream.readUTF();
				sc.close();
				System.out.println("La palabra contiene "+res+" caracteres");
			}
			catch (Exception e){
				System.err.println("excepcion " + e.toString() );
				e.printStackTrace() ;
			}

	}

}
