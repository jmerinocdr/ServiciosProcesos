package es.upm.dit.adsw.practica1;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class PruebaCallejero {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void ordenadasPorCodigo() {
		final String fichero="VialesVigentes_20201220.csv";
		Callejero madrid = null;
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
			madrid = new Callejero(viales,lineas-1);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		int numero = 0;
		Via[] vias = madrid.getVias();
		for(int i=0; i< vias.length-1; i++) {
			if(vias[i].getCodigo() > vias[i+1].getCodigo()) {
				numero++;
			}
		}
		assertEquals(0, numero);
	}
	@Test
	public void referenciasInicioFin() {
		fail("Not yet implemented");
		//A la espera de ver lo que contestan en el foro
	}
	@Test
	public void tiempoEjecucionPorCodigo() {
		/*final String fichero="VialesVigentes_20201220.csv";
		Callejero madrid = null;
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
			madrid = new Callejero(viales,lineas-1);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		Via[] vias = madrid.getVias();
		int tiempoNoComplejo = nanoTime(madrid.ordenaVias());
		int tiempoComplejo = nanoTime(vias[0]algoritmoProfesores(vias));*/
		fail("Not yet implemented");
	}
	@Test
	public void tiempoEjecucionPorNombre() {
		fail("Not yet implemented");
	}


}
