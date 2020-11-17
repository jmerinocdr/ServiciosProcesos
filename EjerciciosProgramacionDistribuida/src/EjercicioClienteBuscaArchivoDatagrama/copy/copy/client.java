package EjercicioClienteBuscaArchivoDatagrama.copy.copy;

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
		System.out.println("Introduce el archivo a guardar: ");
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
			if(vocalesCadena==1) {
				System.out.println("Archivo "+cadenaEnviar+" encontrado");
			}
			else {
				System.out.println("Archivo "+cadenaEnviar+" no encontrado");
			}
			
		}
		catch (Exception e) {
			System.err.println("<<<<<excepcion " + e.toString() );
			e.printStackTrace() ;
		}
	}
}