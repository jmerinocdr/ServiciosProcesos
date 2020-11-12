package EjemploSumaXClienteDatagrama;

//import java.lang.* ; 
import java.io.* ;
import java.net.* ;
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
		int res; int num[] = new int[2];
		if (args.length != 1) {
			System.out.println("Uso: cliente <host>");
			System.exit(0);
		}
	
		try
		{
			// se crea el socket del cliente
			s = new DatagramSocket();
			// direción del servidor
			server_addr = InetAddress.getByName(args[0]);
			num[0] = 2;
			num[1] = 5;
			// empaquetar los datos.
			ByteArrayOutputStream baos = new ByteArrayOutputStream() ;
			ObjectOutputStream dos = new ObjectOutputStream(baos);
			dos.writeObject(num);
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
			res = dis.readInt();
			System.out.println("Datos recibidos " + res);
		}
		catch (Exception e) {
			System.err.println("<<<<<excepcion " + e.toString() );
			e.printStackTrace() ;
		}
	}
}