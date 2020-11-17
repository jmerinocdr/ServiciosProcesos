package EjercicioClienteCuentaConsonantesDatagrama.copy.copy;

//import java.lang.* ; 
import java.io.* ;
import java.net.* ;

import java.util.Scanner;
//import java.util.* ;
public class client{
	public static void main ( String [] args)
	{
		byte bsend[] = new byte[100];
		byte brecv[] = new byte[100];
		InetAddress server_addr = null;
		DatagramSocket s = null;
		DatagramPacket in = null;
		DatagramPacket out = null;
		
		String host="";
		String cadenaEnviar="";
		
		int vocalesCadena;
		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduce el host: ");
		host = teclado.nextLine ();
		System.out.println("Introduce la cadena: ");
		cadenaEnviar = teclado.nextLine ();
		teclado.close();
		
	
		try
		{
			// se crea el socket del cliente
			s = new DatagramSocket();
			// direción del servidor
			server_addr = InetAddress.getByName(host);
			// empaquetar los datos.
			ByteArrayOutputStream baos = new ByteArrayOutputStream() ;
			ObjectOutputStream dos = new ObjectOutputStream(baos);
			dos.writeObject(cadenaEnviar);
			bsend = baos.toByteArray() ; // se obtiene el buffer (datagrama)
			// un único envio
			out = new DatagramPacket (bsend, bsend.length, server_addr, 2500);
			s.send(out);
			
			//se recibe el datagrama de respuesta
			in = new DatagramPacket (brecv, 100);
			s.receive(in);
			//se obtiene el buffer
			brecv = in.getData();
			//se desempaqueta
			ByteArrayInputStream bais = new ByteArrayInputStream(brecv) ;
			DataInputStream dis = new DataInputStream(bais);
			vocalesCadena = dis.readInt();
			System.out.println("Datos recibidos " + vocalesCadena);
		}
		catch (Exception e) {
			System.err.println("<<<<<excepcion " + e.toString() );
			e.printStackTrace() ;
		}
	}
}