package EjercicioServidorAhorcadoStream;

//import java.lang.* ;
import java.io.* ;
import java.net.* ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.* ;
public class servidor
{
	@SuppressWarnings("resource")
	public static void main ( String [] args) throws IOException
	{
		String adiWord=palabraAleatoria();
		String procWord=palabraSinCaracteres(adiWord);
		ServerSocket serverAddr = null;
		Socket sc = null;
		String cadenaRecibida ; // petición
		String retWord="";
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
				
				
				retWord=comprobarPalabra(adiWord, cadenaRecibida, procWord);
				
				
				DataOutputStream ostream = new DataOutputStream(sc.getOutputStream());
				ostream.writeUTF(retWord);
				ostream.flush();
				sc.close();
			}
			catch(Exception e) {
				System.err.println("excepcion " + e.toString() );
				e.printStackTrace() ;
			}
		}
	}
	public static String comprobarPalabra(String adiWord, String cadRecibida, String procWord) {
		
		if(cadRecibida.length()==1) {
			for(int i=0; i<adiWord.length(); i++) {
				if(cadRecibida.charAt(1)==(adiWord.charAt(i))){
					StringBuilder procWordS = new StringBuilder(procWord);
					procWordS.setCharAt(i, cadRecibida.charAt(1));
					procWord=procWordS.toString();
				}
			}
			
			return procWord;
		}
		else {
			return procWord;
		}
		
	}
	public static String palabraSinCaracteres(String adWord) {
		String procWord="";
		for(int i=0; i<adWord.length(); i++) {
			procWord=procWord+"_";
		}
		return procWord;
	}
	public static String palabraAleatoria() throws IOException
    {
		String palabra="";
		String ruta="src\\EjercicioServidorAhorcadoStream\\archivos\\palabras.txt";
		ArrayList<String> filas=new ArrayList<String>();
		//String filePath = new File("").getAbsolutePath();
		//filePath.concat(ruta);
		File archivo=new File(ruta);
		if(archivo.exists()) {
			System.out.println("El archivo existe");
			FileReader archivol = new FileReader(ruta);
			BufferedReader reader = new BufferedReader(archivol);
			String linea;
			while ((linea = reader.readLine()) != null)
			{
			   filas.add(linea);
			}
			reader.close();
			palabra=filas.get(getRandomArbitrary(1, filas.size()-1));
			System.out.println("Palabra elegida es "+palabra);
			return palabra;
		}
		else {
			System.out.println("Palabra elegida es OOOOOOO");
			return "OOOOOOO";
		}
		
    }
	public static int getRandomArbitrary(int min, int max) {
		  return (int)Math.random() * (max - min) + min;
		}
}
