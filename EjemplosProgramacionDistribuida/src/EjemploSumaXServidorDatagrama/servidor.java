package EjemploSumaXServidorDatagrama;

//import java.lang.* ; 
import java.io.* ;
import java.net.* ;
//import java.util.* ;
public class servidor
{
	public static void main ( String [] args) {
	DatagramSocket s = null;
	DatagramPacket in, out;
	InetAddress client_addr = null;
	int client_port;
	byte brecv[] = new byte[100];
	byte bsend[] = new byte[100];
	int num[], res;
		try {
			s = new DatagramSocket(2500);
			in = new DatagramPacket(brecv, 100); // paquete para recibir la solicitud
		
			while (true) {
				s.receive(in); //esperamos a recibir
				// obtener datos
				brecv = in.getData();
				client_addr = in.getAddress();
				client_port = in.getPort();
				// desempaquetar los datos
				ByteArrayInputStream bais = new ByteArrayInputStream(brecv);
				ObjectInputStream dis = new ObjectInputStream(bais);
				num = (int[])dis.readObject();
				res = num[0] + num[1];
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				DataOutputStream dos = new DataOutputStream(baos);
				dos.writeInt(res);
				bsend = baos.toByteArray();
				out = new DatagramPacket ( bsend,
				bsend.length,client_addr,
				client_port);
				s.send(out);
			}
		}
		catch(Exception e) {
			System.err.println("excepcion " + e.toString() );
			e.printStackTrace() ;
		}
	}
}