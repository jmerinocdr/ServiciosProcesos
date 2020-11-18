package EjemploServidorBuscaArchivoStream;

//import java.lang.* ;
import java.io.* ;
import java.net.* ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.* ;
public class servidor
{
	@SuppressWarnings("resource")
	public static void main ( String [] args)
	{
		ServerSocket serverAddr = null;
		Socket sc = null;
		String cadenaRecibida ; // petición
		int encontrado=0;
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
				
				String directorio = "D:\\Jaime\\Documents\\Eclipse-workspace\\ServiciosProcesos\\EjerciciosProgramacionDistribuida\\src\\EjercicioServidorBuscaArchivoStream\\datos";
				
				if(encontrarArchivo(cadenaRecibida, directorio)==true) {
					encontrado=1;
				}
				
				
				DataOutputStream ostream = new DataOutputStream(sc.getOutputStream());
				ostream.writeInt(encontrado);
				ostream.flush();
				sc.close();
			}
			catch(Exception e) {
				System.err.println("excepcion " + e.toString() );
				e.printStackTrace() ;
			}
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
