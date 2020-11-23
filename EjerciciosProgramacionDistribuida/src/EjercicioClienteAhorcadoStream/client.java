package EjercicioClienteAhorcadoStream;

//import java.lang.* ;
import java.io.* ;
import java.net.* ;
import java.util.Scanner;
//import java.util.* ;
public class client
{
	public static void main ( String [] args)
	{
		String host="";
		String cadenaEnviar="";
		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduce el host: ");
		host = teclado.nextLine ();
		System.out.println("Introduce una letra a adivinar: ");
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
			System.out.println(res);
		}
		catch (Exception e){
			System.err.println("excepcion " + e.toString() );
			e.printStackTrace() ;
		}
	}
}