package EjercicioServidorBuscaArchivoDatagrama;

//import java.lang.* ; 
import java.io.* ;
import java.net.* ;
import java.nio.file.Files;
//import java.util.* ;

import java.nio.file.Path;
import java.nio.file.Paths;
public class servidor
{
	public static void main ( String [] args) {
	DatagramSocket s = null;
	DatagramPacket in, out;
	InetAddress client_addr = null;
	int client_port;
	byte brecv[] = new byte[100];
	byte bsend[] = new byte[100];
	String cadenaRecibida="";
	int encontrado=0;
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
				cadenaRecibida = (String) dis.readObject();
				
				String directorio = "D:\\Jaime\\Documents\\Eclipse-workspace\\ServiciosProcesos\\EjerciciosProgramacionDistribuida\\src\\EjercicioServidorBuscaArchivoDatagrama\\datos";
				
				if(encontrarArchivo(cadenaRecibida, directorio)==true) {
					encontrado=1;
				}
				
				
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				DataOutputStream dos = new DataOutputStream(baos);
				dos.writeInt(encontrado);
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
	
	public static boolean encontrarArchivo(String archivo,String directorio)
    {
		String filePath= directorio+"/"+archivo;
		Path path = Paths.get(filePath);
		boolean exists = Files.exists(path);
		return exists;
    }
	
}