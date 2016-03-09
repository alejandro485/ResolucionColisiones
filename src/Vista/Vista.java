package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Logica.DobleHash;
import Logica.EncadenamientoLineal;
import Logica.EncadenamientoSeparado;
import Logica.PruebaCuadratica;

public class Vista extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private EncadenamientoSeparado encSep;
	private EncadenamientoLineal encLin;
	private DobleHash dobHas;
	private PruebaCuadratica pruCua;
	
	private JPanel contentPane;
	private JTextField txtTamano;
	private JTextField txtLlaves;
	private JButton btnEncSep;
	private JButton btnEnclin;
	private JButton btnDobhash;
	private JButton btnPrucua;
	private CanvasLista canvas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTamano = new JLabel("Tamaño del arreglo");
		lblTamano.setBounds(12, 20, 154, 15);
		contentPane.add(lblTamano);
		
		txtTamano = new JTextField();
		txtTamano.setBounds(165, 18, 90, 19);
		contentPane.add(txtTamano);
		txtTamano.setColumns(10);
		
		JLabel lblLlaves = new JLabel("Llaves a ingresar en el arreglo:");
		lblLlaves.setBounds(24, 49, 231, 15);
		contentPane.add(lblLlaves);
		
		txtLlaves = new JTextField();
		txtLlaves.setBounds(12, 76, 246, 19);
		contentPane.add(txtLlaves);
		txtLlaves.setColumns(10);
		
		btnEncSep = new JButton("Encadenamiento separado");
		btnEncSep.setBounds(12, 107, 243, 25);
		btnEncSep.addActionListener(this);
		btnEncSep.setActionCommand("es");
		contentPane.add(btnEncSep);
		
		btnEnclin = new JButton("Encadenamiento Lineal");
		btnEnclin.setBounds(12, 144, 243, 25);
		btnEnclin.addActionListener(this);
		btnEnclin.setActionCommand("el");
		contentPane.add(btnEnclin);
		
		btnDobhash = new JButton("Doble Hash");
		btnDobhash.setBounds(12, 181, 243, 25);
		btnDobhash.addActionListener(this);
		btnDobhash.setActionCommand("dh");
		contentPane.add(btnDobhash);
		
		btnPrucua = new JButton("Prueba Cuadratica");
		btnPrucua.setBounds(12, 218, 243, 25);
		btnPrucua.addActionListener(this);
		btnPrucua.setActionCommand("pc");
		contentPane.add(btnPrucua);
		
		canvas= new CanvasLista();
		canvas.setBounds(264,10,815, 579);
		canvas.setVisible(true);
		contentPane.add(canvas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "es":
				System.out.println("Encadenamiento separado");
				encSep=new EncadenamientoSeparado(Integer.parseInt(txtTamano.getText()));
				encSep.agregarLlave(txtLlaves.getText());
				canvas.setLista(encSep.b);
				break;
			case "el":
				System.out.println("Encadenamiento lineal");
				encLin=new EncadenamientoLineal(Integer.parseInt(txtTamano.getText()));
				encLin.agregarLlave(txtLlaves.getText());
				canvas.setLista(encLin.b);
				break;
			case "dh":
				System.out.println("Doble hash");
				dobHas=new DobleHash(Integer.parseInt(txtTamano.getText()));
				dobHas.agregarLlave(txtLlaves.getText());
				canvas.setLista(dobHas.b);
				break;
			case "pc":
				System.out.println("Prueba cuadratica");
				pruCua=new PruebaCuadratica(Integer.parseInt(txtTamano.getText()));
				pruCua.agregarLlave(txtLlaves.getText());
				canvas.setLista(pruCua.b);
				break;
		}
	}
}
