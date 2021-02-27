package ServerRaya;

public class Data {
	private String name;
	private String serverip;
	private String playerip;
	private String[][] tabla;
	
	public Data(String name, String serverip, String playerip, String[][] tabla) {
		this.setName(name);
		this.setServerip(serverip);
		this.setPlayerip(playerip);
		this.setTabla(tabla);
	}
	
	public String getName() {
		return name;
	}
	public String getServerip() {
		return serverip;
	}
	public String getPlayerip() {
		return playerip;
	}
	public String[][] getTabla() {
		return tabla;
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setServerip(String serverip) {
		this.serverip = serverip;
	}
	private void setPlayerip(String playerip) {
		this.playerip = playerip;
	}
	private void setTabla(String[][] tabla) {
		this.tabla = tabla;
	} 
	
	
}
