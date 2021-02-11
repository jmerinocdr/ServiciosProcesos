package EjercicioClienteTresEnRaya;

import java.io.Serializable;

public class Data implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre, ip;
	private String[][] tabla;
		
	public String getNombre() {
		return nombre;
	}
	public String getIp() {
		return ip;
	}
	public String[][] getTabla() {
		return tabla;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setTabla(String[][] tabla) {
		this.tabla = tabla;
	}
}
