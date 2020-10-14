package DemoJoin;

public class Vector extends Thread{
	private int[] datos;
	private String nombre;
	private int tam;
	private int suma;
	private long sumaSqr;
	private double media;
	
	Vector (int t, String n){
		this.setNombre(n);
		this.setTam(t);
		this.setSuma(0);
		this.setSumaSqr(0);
		this.setMedia(0.0);
		this.setDatos(new int[this.getTam()]);
		for(int i=0; i<this.getTam();i++) {
			this.getDatos()[i]=(int)(Math.random()*100.0);
		}
	}

	public void run() {
		for(int i=0; i<this.getTam(); i++) {
			System.out.println(this.getNombre()+":"+i);
			this.suma+=this.getDatos()[i];
			this.sumaSqr+=this.getDatos()[i]*this.getDatos()[i];
		}
		this.setMedia((double) this.getSuma()/(double) this.getTam());
	}
	
	public int[] getDatos() {
		return datos;
	}

	public void setDatos(int[] datos) {
		this.datos = datos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public long getSumaSqr() {
		return sumaSqr;
	}

	public void setSumaSqr(long sumaSqr) {
		this.sumaSqr = sumaSqr;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	
}
