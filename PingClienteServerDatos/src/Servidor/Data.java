package Servidor;

import java.io.Serializable;

public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String iporigen;
	private int puertoorigen;
	private String ipdestino;
	private int puertodestino;
	private String mensaje;
	public Data() {
		
	}
	public Data(String iporigen, int puertoorigen, String ipdestino, int puertodestino, String mensaje) {
		this.setIporigen(iporigen);
		this.setPuertoorigen(puertoorigen);
		this.setIpdestino(ipdestino);
		this.setPuertodestino(puertodestino);
		this.setMensaje(mensaje);
		
	}
	public String getIporigen() {
		return iporigen;
	}
	public String getIpdestino() {
		return ipdestino;
	}
	public String getMensaje() {
		return mensaje;
	}
	private void setIporigen(String iporigen) {
		this.iporigen = iporigen;
	}
	private void setIpdestino(String ipdestino) {
		this.ipdestino = ipdestino;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getPuertodestino() {
		return puertodestino;
	}
	public void setPuertodestino(int puertodestino) {
		this.puertodestino = puertodestino;
	}
	public int getPuertoorigen() {
		return puertoorigen;
	}
	public void setPuertoorigen(int puertoorigen) {
		this.puertoorigen = puertoorigen;
	}
	
}
