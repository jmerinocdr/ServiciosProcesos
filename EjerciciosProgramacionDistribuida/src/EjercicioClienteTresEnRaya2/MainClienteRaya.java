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
		
		
			System.out.println("Introduce la posición x del nuevo valor: (0-2)");
			x = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce la posición y del nuevo valor: (0-2)");
			y = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce el símbolo con el que estés jugando");
			symb = teclado.nextLine();
			System.out.println("Estás seguro de enviar "+symb+" en la posición x"+x+"-y"+y);
			check = teclado.nextLine();
			if(check.equals("y")||check.equals("y")) {
				clienteRaya.anadirTabla(x,y,symb);
				clienteRaya.sendData();
			}
			else {
				System.out.println("Operación cancelada");
			}
		

	}

}
