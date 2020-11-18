package EjemploClienteBuscaArchivoStream;

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
		System.out.println("Introduce el archivo a guardar: ");
		cadenaEnviar = teclado.nextLine ();
		teclado.close();
		
		int res;
		if (args.length != 1) {
			System.out.println("Uso: cliente <host>");
			System.exit(0);
		}
		try {
			// se crea la conexión
			Socket sc = new Socket(host, 2500); // conexión
			OutputStream ostream = sc.getOutputStream();
			ObjectOutput s = new ObjectOutputStream(ostream);
			DataInputStream istream = new DataInputStream(sc.getInputStream());
			s.writeObject(cadenaEnviar);
			s.flush();
			res = istream.readInt();
			sc.close();
			if(res==1) {
				System.out.println("Archivo "+cadenaEnviar+" encontrado");
			}
			else {
				System.out.println("Archivo "+cadenaEnviar+" no encontrado");
			}
			System.out.println("La suma es " + res);
		}
		catch (Exception e){
			System.err.println("excepcion " + e.toString() );
			e.printStackTrace() ;
		}
	}
}