package EjemploSumaXClienteStream;

//import java.lang.* ;
import java.io.* ;
import java.net.* ;
//import java.util.* ;
public class client
{
	public static void main ( String [] args)
	{
		int res;
		int num[] = new int[2];
		if (args.length != 1) {
			System.out.println("Uso: cliente <host>");
			System.exit(0);
		}
		try {
			// se crea la conexión
			String host = args[0];
			Socket sc = new Socket(host, 2500); // conexión
			OutputStream ostream = sc.getOutputStream();
			ObjectOutput s = new ObjectOutputStream(ostream);
			DataInputStream istream = new DataInputStream(sc.getInputStream());
			num[0] = 5; num[1] = 2; //prepara la petición
			s.writeObject(num);
			s.flush();
			res = istream.readInt();
			sc.close();
			System.out.println("La suma es " + res);
		}
		catch (Exception e){
			System.err.println("excepcion " + e.toString() );
			e.printStackTrace() ;
		}
	}
}