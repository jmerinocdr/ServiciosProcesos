package EjercicioClienteTresEnRaya2;

import java.util.Scanner;

public class MainClienteRaya {

	public static void main(String[] args) {
		ClienteRaya clienteRaya = new ClienteRaya();
		boolean eject=true;
		int x;
		int y;
		String symb;
		String check;
		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduce tu nombre: ");
		clienteRaya.setNombre(teclado.nextLine ());
		System.out.println("Introduce la ip del contrincante: ");
		clienteRaya.setIp(teclado.nextLine ());
		
		
			System.out.println("Introduce la posici�n x del nuevo valor: (0-2)");
			x = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce la posici�n y del nuevo valor: (0-2)");
			y = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce el s�mbolo con el que est�s jugando");
			symb = teclado.nextLine();
			System.out.println("Est�s seguro de enviar "+symb+" en la posici�n x"+x+"-y"+y);
			check = teclado.nextLine();
			if(check.equals("y")||check.equals("y")) {
				clienteRaya.anadirTabla(x,y,symb);
				clienteRaya.sendData();
			}
			else {
				System.out.println("Operaci�n cancelada");
			}
		

	}

}
