package ScrapeTitulos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeTitulos {
	public static void main(String[] args) {
		String fichero="D:\\Jaime\\Documents\\Eclipse-workspace\\ServiciosProcesos\\EjemplosJsoup\\src\\ScrapeTitulos\\Paginas.txt";
		try {
			FileInputStream fis = new FileInputStream(fichero);
			InputStreamReader isr = new InputStreamReader(fis, "utf8");
			BufferedReader br = new BufferedReader(isr);
			
			String linea;
			File arch=new File("D:\\Jaime\\Documents\\Eclipse-workspace\\ServiciosProcesos\\EjemplosJsoup\\src\\ScrapeTitulos\\Noticias");
			arch.mkdir();
			while((linea = br.readLine())!=null) {
				System.out.println(linea);
				
				String lineas = linea.substring(6);
				File arch1=new File("D:\\Jaime\\Documents\\Eclipse-workspace\\ServiciosProcesos\\EjemplosJsoup\\src\\ScrapeTitulos\\Noticias\\"+lineas+".txt");
				arch1.createNewFile();
				FileWriter archivo = new FileWriter(arch1,true);
				PrintWriter pw = new PrintWriter(archivo);
				
				Document doc = Jsoup.connect(linea).get();
				
				Elements h2 = doc.select("h2>a");
				Elements h3 = doc.select("h2>a");
				
				for(Element titulo : h2) {
					System.out.println(titulo.attr("title"));
					pw.println(titulo.attr("title"));
				}
				for(Element titulo : h3) {
					System.out.println(titulo.attr("title"));
					pw.println(titulo.attr("title"));
				}
			}
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
