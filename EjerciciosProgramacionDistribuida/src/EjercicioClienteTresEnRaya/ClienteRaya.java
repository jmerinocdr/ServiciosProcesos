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
	JButton btn00, btn01, btn02, 
			btn10, btn11, btn12, 
			btn20, btn21, btn22;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Escucha escucha=new Escucha();
		escucha.run();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteRaya window = new ClienteRaya();
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
		
		btn00 = new JButton(" ");
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(0,0,symb);
				btn00.setText(symb);
			}
		});
		panel.add(btn00);
		
		btn01 = new JButton(" ");
		btn01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(0,1,symb);
				btn01.setText(symb);
			}
		});
		panel.add(btn01);
		
		btn02 = new JButton(" ");
		btn02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(0,2,symb);
				btn02.setText(symb);
			}
		});
		panel.add(btn02);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		btn10 = new JButton(" ");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(1,0,symb);
				btn10.setText(symb);
			}
		});
		panel.add(btn10);
		
		btn11 = new JButton(" ");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(1,1,symb);
				btn11.setText(symb);
			}
		});
		panel.add(btn11);
		
		btn12 = new JButton(" ");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(1,2,symb);
				btn12.setText(symb);
			}
		});
		panel.add(btn12);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);
		
		btn20 = new JButton(" ");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(2,0,symb);
				btn20.setText(symb);
			}
		});
		panel.add(btn20);
		
		btn21 = new JButton(" ");
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(2,1,symb);
				btn21.setText(symb);
			}
		});
		panel.add(btn21);
		
		btn22 = new JButton(" ");
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.anadirTabla(2,2,symb);
				btn22.setText(symb);
			}
		});
		panel.add(btn22);
		
		JButton Send = new JButton("Enviar");
		Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Llamamos al sendData");
				sendData();
			}
			
		});
		panel.add(Send);
	}
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
			datos.setStr(symb);
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
	public void setData(Data data) {
		String[][] stabla = data.getTabla();
		System.out.println("El symb vale "+symb+" y data recibida vale "+data.getStr());
		if(data.getStr().equals("O")) {
			System.out.println("Symb es X porque recibió O");
			this.setSymb("X");
		}
		System.out.println("Tras procesar ...");
		System.out.println("El symb vale "+symb+" y data recibida vale "+data.getStr());
		this.tabla.setTabla(stabla);
		System.out.println("Recibido "
				+ "\n"+stabla[0][0]+"|"+stabla[0][1]+"|"+stabla[0][2]
				+ "\n"+stabla[1][0]+"|"+stabla[1][1]+"|"+stabla[1][2]
				+ "\n"+stabla[2][0]+"|"+stabla[2][1]+"|"+stabla[2][2]
				+ "\n -----------------------------------------------");
		updateUITabla(stabla);
	}
	private void updateUITabla(String[][] stabla) {
		btn00.setText(stabla[0][0]);
		btn01.setText(stabla[0][1]);
		btn02.setText(stabla[0][2]);
		btn10.setText(stabla[1][0]);
		btn11.setText(stabla[1][1]);
		btn12.setText(stabla[1][2]);
		btn20.setText(stabla[2][0]);
		btn21.setText(stabla[2][1]);
		btn22.setText(stabla[2][2]);
	}
	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




