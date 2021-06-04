package es.upm.dit.adsw.practica1;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

/**
 * Clase para representar contenidos de los ficheros de viales que distribuye
 * el ayuntamiento de Madrid
 * 
 * @author mmiguel
 *
 */
public class Callejero {

	private static final int COD_VIA=0;
	private static final int VIA_CLASE=1;
	private static final int VIA_PAR=2;
	private static final int VIA_NOMBRE=3;
	private static final int VIA_NOMBRE_ACENTOS=4;
	private static final int COD_VIA_COMIENZA=5;
	private static final int CLASE_COMIENZA=6;
	private static final int PARTICULA_COMIENZA=7;
	private static final int NOMBRE_COMIENZA=8;
	private static final int NOMBRE_ACENTOS_COMIENZA=9;
	private static final int COD_VIA_TERMINA=10;
	private static final int CLASE_TERMINA=11;
	private static final int PARTICULA_TERMINA=12;
	private static final int NOMBRE_TERMINA=13;
	private static final int NOMBRE_ACENTOS_TERMINA=14;

	protected static final String fichero="VialesVigentes_20201220.csv";
	protected Via[] vias;
	
	private Via[] viasOrdenadasNombre;

	/**
	 * Constructor de callejero a partir de algun tipo de stream que 
	 * incluye las vias del callejero. Ese stream esta soportado con un Scanner. 
	 * El scanner incluye el contenido del callejero y el constructor lee el stream 
	 * que debe estar en formato csv
	 * 
	 * @param viales scanner del que extraemos el contenido del callejero
	 * @param numViales numero de viales que incluye el scanner
	 */
	public Callejero(Scanner viales,int numViales) {
		vias=new Via[numViales];
		String[] vias_csv;
		for (int i=0; i < numViales; i++) {
			String linea=viales.nextLine();
			vias_csv=linea.split(";");
			vias[i]=new Via(Integer.parseInt(vias_csv[COD_VIA]),vias_csv[VIA_CLASE],vias_csv[VIA_PAR],
					vias_csv[VIA_NOMBRE],vias_csv[VIA_NOMBRE_ACENTOS],
					Integer.parseInt(vias_csv[COD_VIA_COMIENZA]),Integer.parseInt(vias_csv[COD_VIA_TERMINA]));
			if ((i == numViales-1 && viales.hasNext()) || (i < numViales-1 && !viales.hasNext()))
				throw new RuntimeException("Formato fichero errorneo");
		}
		viales.close();
		ordenaVias();
		referenciaVias();
		
		
	}
	
	/**
	 * Metodo que ordena las vias en función del código de via.
	 * Debe ser utilizado unicamente para hacer pruebas
	 */
	public void ordenaVias() {
		sortCode(vias);
	}
	
	/**
	 * Metodos que aparecen en las transparencias del moodle adaptados para el proposito que nos piden
	 * Permite ordenar con una complejidad baja la lista
	 */
	private void sortCode(Via[] listaVias) {
		List<Via> lista = new ArrayList<>();
		Collections.addAll(lista, listaVias);
		mergeSortCode(lista);
		lista.toArray(listaVias);
	}
	
	private void mergeSortCode(List<Via> listVia) {
		if(listVia.size() < 2) {
			return;
		}
		int m = listVia.size() / 2;
		List<Via> auxIzq = new ArrayList<>(listVia.subList(0, m));
		List<Via> auxDer = new ArrayList<>(listVia.subList(m, listVia.size()));
		mergeSortCode(auxIzq);
		mergeSortCode(auxDer);
		
		listVia.clear();
		while (auxIzq.size() > 0 && auxDer.size() > 0) {
			Integer codeIzq = auxIzq.get(0).getCodigo();
			Integer codeDer = auxDer.get(0).getCodigo();
			if(codeIzq.compareTo(codeDer) < 0) {
				listVia.add(auxIzq.remove(0));
			}
			else {
				listVia.add(auxDer.remove(0));
			}
		}
		while(auxIzq.size() > 0) {
			listVia.add(auxIzq.remove(0));
		}
		while(auxDer.size() > 0) {
			listVia.add(auxDer.remove(0));
		}
		
	}
	
	private void referenciaVias() {
		/*
		for(int i = 0; i < vias.length; i++) {
			try {
			vias[i].setViaComienzo(vias[pos(vias[i].getComienza())]);
			vias[i].setViaTermina(vias[pos(vias[i].getTermina())]);
			}
			catch(Exception E) {
				
			}
		}
		*/
		/*for(int i = 0; i < vias.length; i++) {
			for(int o = 0; o < vias.length; o++) {
				if(vias[i].getComienza()==vias[o].getCodigo()) {
					vias[i].setViaComienzo(vias[o]);
				}
				if(vias[i].getTermina()==vias[o].getCodigo()) {
					vias[i].setViaTermina(vias[o]);;
				}
			}
		}*/
	}
	
	private int pos(int posicion) {
		int arraypos = 0;
		for(int i = 0; i < vias.length; i++) {
			if(posicion == vias[i].getCodigo()) {
				arraypos = i;
				return arraypos;
			}
		}
		return arraypos;
	}
	
	
	/**
	 * Imprime en salida estandar todos los viales del callejero
	 */
	public void printViales() {
		for (Via via : vias) {
			via.formatPrint();
			System.out.println();
		}
	}
	
	/**
	 * Devuelve las vias del callejero
	 * @return vias del callejero
	 */
	public Via[] getVias() {
		return vias;
	}
	
	/**
	 * Fija las vias del callejero. Debe estar completamente inicializada
	 * @param vias nuevas vias del callejero
	 */
	public void setVias(Via[] vias) {
		this.vias = vias;
	}
	
	/**
	 * Devuelve el cojunto de vias del callejero ordenadas por nombre
	 * 
	 * @return conjunto de vias ordenadas por nombre 
	 */
	public Via[] ordenaViasPorNombre() {
		if(this.viasOrdenadasNombre != null) {
			return this.viasOrdenadasNombre;
		}
		else {
			
			return null;
		}
		
	}
	
	private void sortNombre(Via[] listaVias) {
		List<Via> lista = new ArrayList<>();
		Collections.addAll(lista, listaVias);
		mergeSortNombre(lista);
		lista.toArray(listaVias);
	}
	
	private void mergeSortNombre(List<Via> listVia) {
		if(listVia.size() < 2) {
			return;
		}
		int m = listVia.size() / 2;
		List<Via> auxIzq = new ArrayList<>(listVia.subList(0, m));
		List<Via> auxDer = new ArrayList<>(listVia.subList(m, listVia.size()));
		mergeSortNombre(auxIzq);
		mergeSortNombre(auxDer);
		
		listVia.clear();
		while (auxIzq.size() > 0 && auxDer.size() > 0) {
			Integer codeIzq = auxIzq.get(0).getCodigo();
			Integer codeDer = auxDer.get(0).getCodigo();
			if(codeIzq.compareTo(codeDer) < 0) {
				listVia.add(auxIzq.remove(0));
			}
			else {
				listVia.add(auxDer.remove(0));
			}
		}
		while(auxIzq.size() > 0) {
			listVia.add(auxIzq.remove(0));
		}
		while(auxDer.size() > 0) {
			listVia.add(auxDer.remove(0));
		}
		
	}
	

	public static void main(String[] args) {
		try {
			FileInputStream fi=new FileInputStream(fichero);
			Scanner viales=new Scanner(fi);
			int lineas=0;
			while (viales.hasNext()) {
				lineas++;
				viales.nextLine();
			}
			viales.close();
			fi=new FileInputStream(fichero);
			viales=new Scanner(fi);
			viales.nextLine(); // nos saltamos las cabeceras del fichero
			Callejero c=new Callejero(viales,lineas-1);
			c.printViales();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
