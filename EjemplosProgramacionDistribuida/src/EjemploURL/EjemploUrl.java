package EjemploURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class EjemploUrl {


	public static void main(String[] args) {

		String strUrl; 
		URL url;	

		strUrl = "https://www.google.com";	
		try {
			url = new URL(strUrl);
		} catch (MalformedURLException e) {
			System.err.println("Error " + e.getLocalizedMessage());
			return;
		}

		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
		}
		catch (IOException ioe) {
			System.err.println("Error lectura: " + ioe.getLocalizedMessage());
			return;
		}
		String inputLine;
		String patron="<img ";
		int numImagenes=0;
		
		try {
			while ((inputLine = in.readLine()) != null) {
				if(inputLine.contains(patron)) {
					numImagenes++;
				}
			}
			System.out.println(numImagenes);
		}
		catch(IOException ioe) {
			System.err.println("Error leyendo el contenido de la URL.");
		}
		
		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();
		}
		catch(IOException ioe) {
			System.err.println("Error leyendo el contenido de la URL.");
		}

	} 
} 