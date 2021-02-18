package EjercicioClienteTresEnRaya2;

import java.io.Serializable;

public class Data implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre, ip;
	private String[][] tabla;
	private String str;
		
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
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
