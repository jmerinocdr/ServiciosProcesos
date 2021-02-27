package ClientRaya;

import java.util.Scanner;

public class ClientRayaMain {

	public static void main(String[] args) {
		boolean eject=true;
		int turno=0;
		
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Quién eres??");
		String name=teclado.nextLine();
		System.out.println("Cuál es la ip del servidor??");
		String serverip=teclado.nextLine();
		System.out.println("Cuál es la ip del contrincante??");
		String playerip=teclado.nextLine();
		
		ClientRaya cliente = new ClientRaya(name, serverip, playerip);
		
		cliente.sendPing();
		turno = cliente.getTurno();
		if(turno==2) {
			cliente.recibe();
		}
		
		while(eject==true) {
			cliente.printTabla();
			System.out.println("Introduce el simbolo");
			String symb=teclado.nextLine();
			System.out.println("Introduce posición x");
			int x=teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce posicion y");
			int y=teclado.nextInt(); teclado.nextLine();
			cliente.setTabla(x, y, symb);
			cliente.getTabla();
			
		}
		teclado.close();

	}

}
