package EjercicioClienteTresEnRaya;

public class Tabla {
	String[][] tabla = new String[3][3];
	public Tabla() {
		
	}
	public String[][] getTabla() {
		return tabla;
	}
	public void setTabla(String[][] tabla) {
		this.tabla = tabla;
	}
	public void anadirTabla(int x, int y, String simbolo) {
		if(this.tabla[x][y]==null) {
			this.tabla[x][y]=simbolo;
		}
		else {}
	}
}
