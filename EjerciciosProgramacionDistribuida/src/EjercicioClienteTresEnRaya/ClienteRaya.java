package EjercicioClienteTresEnRaya;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
import javax.swing.JSeparator;

public class ClienteRaya {

	private JFrame frame;
	private JTextField Nombre;
	private JTextField IP;
	private Tabla tabla = new Tabla();
	private String symb="O";
	private void setSymb(String symb) {
		this.symb = symb;
	}
	private String getSymb() {
		return this.symb;
	}
	JButton btn00, btn01, btn02, 
				   btn10, btn11, btn12, 
				   btn20, btn21, btn22;
	
	JTextComponent btno00, btno01, btno02, 
	   btno10, btno11, btno12, 
	   btno20, btno21, btno22;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ClienteRaya window = new ClienteRaya();
		Escucha escucha=new Escucha();
		escucha.run(window);
		System.out.println("ENTRA EL HILO DE LA INTERFAZ");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Establece el ");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}

	/**
	 * Create the application.
	 */
	public ClienteRaya() {
		System.out.println("Se crea CLIENTE RAYA");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setText("Nombre");
		panel.add(txtpnNombre);
		
		Nombre = new JTextField();
		panel.add(Nombre);
		Nombre.setColumns(10);
		
		JTextPane txtpnIp = new JTextPane();
		txtpnIp.setText("IP");
		panel.add(txtpnIp);
		
		IP = new JTextField();
		panel.add(IP);
		IP.setColumns(10);
		
		this.btn00 = new JButton(" ");
		this.btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(0,0);
				btn00.setText(getSymb()); 
			}
		});
		panel.add(this.btn00);
		
		this.btn01 = new JButton(" ");
		this.btn01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(0,1);
				btn01.setText(getSymb());
			}
		});
		panel.add(this.btn01);
		
		this. btn02 = new JButton(" ");
		this.btn02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(0,2);
				btn02.setText(getSymb());
			}

		});
		panel.add(this.btn02);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		this.btn10 = new JButton(" ");
		this.btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(1,0);
				btn10.setText(getSymb());
			}
		});
		panel.add(this.btn10);
		
		this.btn11 = new JButton(" ");
		this.btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(1,1);
				btn11.setText(getSymb());
			}
		});
		panel.add(this.btn11);
		
		this.btn12 = new JButton(" ");
		this.btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(1,2);
				btn12.setText(getSymb());
			}
		});
		panel.add(this.btn12);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);
		
		this.btn20 = new JButton(" ");
		this.btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(2,0);
				btn20.setText(getSymb());
			}
		});
		panel.add(this.btn20);
		
		this.btn21 = new JButton(" ");
		this.btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(2,1);
				btn21.setText(getSymb());
			}
		});
		panel.add(this.btn21);
		
		this.btn22 = new JButton(" ");
		this.btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirTabla(2,2);
				btn22.setText(getSymb());
			}
		});
		panel.add(this.btn22);
		
		JButton Send = new JButton("Enviar");
		Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Llamamos al sendData");
				sendData();
			}
			
		});
		panel.add(Send);
	}
	
	
	//Método para añadir valores en la tabla
	private void anadirTabla(int x, int y) {
		mostrarTabla();
		this.tabla.anadirTabla(x, y, this.getSymb());
		mostrarTabla();
	}
	
	
	//Método para enviar los datos de la tabla
	private void sendData() {
		System.out.println("Entramos al sendData");
		try {
			System.out.println("Creamos socket");
			sleep(1000);
			Socket sc=new Socket("Unknow-PC", 2500);
			System.out.println("Creamos data");
			sleep(1000);
			Data datos=new Data();
			System.out.println("Introducimos datos al data");
			sleep(1000);
			datos.setStr(getSymb());
			datos.setNombre(Nombre.getText());
			datos.setIp(IP.getText());
			datos.setTabla(tabla.getTabla());
			System.out.println("Generamos el ostream");
			sleep(1000);
			ObjectOutputStream ostream = new ObjectOutputStream(sc.getOutputStream());
			System.out.println("enviamos el ostream");
			sleep(1000);
			ostream.writeObject(datos);
			System.out.println("cerramos el socket");
			sleep(1000);
			sc.close();
		} catch (UnknownHostException e1) {
			System.out.println("--PROBLEMA CON EL HOST--");
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	//Método para guardar los datos que se han recibido
	public void setData(Data data) {
		String[][] stabla = data.getTabla();
		System.out.println("El symb vale "+getSymb()+" y data recibida vale "+data.getStr());
		if(data.getStr().equals("O")) {
			System.out.println("Symb es X porque recibió O");
			this.setSymb("X");
		}
		System.out.println("Tras procesar ...");
		System.out.println("El symb vale "+getSymb()+" y data recibida vale "+data.getStr());
		this.tabla.setTabla(stabla);
		System.out.println("Recibido "
				+ "\n"+stabla[0][0]+"|"+stabla[0][1]+"|"+stabla[0][2]
				+ "\n"+stabla[1][0]+"|"+stabla[1][1]+"|"+stabla[1][2]
				+ "\n"+stabla[2][0]+"|"+stabla[2][1]+"|"+stabla[2][2]
				+ "\n -----------------------------------------------");
		updateUITabla(stabla);
	}
	
	
	//Método para actualizar el texto de la tabla
	private void updateUITabla(String[][] stabla) {
		System.out.println("Establecemos el valor de los BTN");
		this.btn00.setText(stabla[0][0]);
		this.btn01.setText(stabla[0][1]);
		this.btn02.setText(stabla[0][2]);
		this.btn10.setText(stabla[1][0]);
		this.btn11.setText(stabla[1][1]);
		this.btn12.setText(stabla[1][2]);
		this.btn20.setText(stabla[2][0]);
		this.btn21.setText(stabla[2][1]);
		this.btn22.setText(stabla[2][2]);
	}
	
	
	//Método para realizar una espera
	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Método para mostrar los valores de la tabla actual
	private void mostrarTabla() {
		System.out.println("Tabla: "
				+ "\n"+this.tabla.getTabla()[0][0]+"|"+this.tabla.getTabla()[0][1]+"|"+this.tabla.getTabla()[0][2]
				+ "\n"+this.tabla.getTabla()[1][0]+"|"+this.tabla.getTabla()[1][1]+"|"+this.tabla.getTabla()[1][2]
				+ "\n"+this.tabla.getTabla()[2][0]+"|"+this.tabla.getTabla()[2][1]+"|"+this.tabla.getTabla()[2][2]
				+ "\n -----------------------------------------------");
	}

}




