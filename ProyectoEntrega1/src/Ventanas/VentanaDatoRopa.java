package Ventanas;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Articulo;
import Clases.Compra;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JTextField;
/**
 * Ventana que nos muestra las caracteristicas de cada articulo 
 * @author Amaia, Marta y Garbi�e
 *
 */
public class VentanaDatoRopa extends JFrame implements ActionListener{

	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	private JButton btnVolver, btnComprarArticulo;
	private JLabel lblCodigo, lblNombre, lblPrecio,lblFoto,lblTalla,lblUnidades;
	private JFrame ventanaAnterior;
	private String ruta;
	private Articulo a;
	private JComboBox comboBox;
	private JTextField txtUnidades;
	
	private void cargarComboBox(){


		comboBox.addItem("XS");
		comboBox.addItem("S");
		comboBox.addItem("M");
		comboBox.addItem("L");



	}
	/**
	 * Create the frame.
	 */
	public VentanaDatoRopa(JFrame va, String r) {
		ruta = r;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		panelSur.add(btnVolver);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		a = VentanaPrincipal.bd.obtenerArticulo(ruta);
		
		ImageIcon im = new ImageIcon(a.getRuta());

		lblFoto = new JLabel(im);
		lblFoto.setBounds(12, 13, 200, 220);
		panelCentro.add(lblFoto);

		lblCodigo = new JLabel(String.valueOf(a.getCodigo()));
		lblCodigo.setBounds(332, 13, 74, 29);
		panelCentro.add(lblCodigo);

		lblNombre = new JLabel(a.getNombre());
		lblNombre.setBounds(332, 66, 85, 29);
		panelCentro.add(lblNombre);

		lblPrecio = new JLabel(String.valueOf(a.getPrecio()));
		lblPrecio.setBounds(332, 118, 111, 29);
		panelCentro.add(lblPrecio);

		btnComprarArticulo = new JButton("A\u00D1ADIR AL CARRITO");
		btnComprarArticulo.setBounds(154, 248, 153, 34);
		btnComprarArticulo.addActionListener(this);
		panelCentro.add(btnComprarArticulo);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCodigo.setBounds(213, 19, 56, 16);
		panelCentro.add(lblCodigo);
		
		lblNombre= new JLabel("Nombre:");
		lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNombre.setBounds(213, 72, 56, 16);
		panelCentro.add(lblNombre);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblPrecio.setBounds(213, 124, 56, 16);
		panelCentro.add(lblPrecio);
		
		comboBox = new JComboBox();
		comboBox.setBounds(332, 173, 44, 22);
		panelCentro.add(comboBox);
		cargarComboBox();
		
		lblTalla = new JLabel("Talla : ");
		lblTalla.setBounds(213, 176, 56, 16);
		panelCentro.add(lblTalla);
		
		lblUnidades = new JLabel("Unidades:");
		lblUnidades.setBounds(213, 217, 74, 16);
		panelCentro.add(lblUnidades);
		
		txtUnidades = new JTextField();
		txtUnidades.setBounds(332, 211, 44, 22);
		panelCentro.add(txtUnidades);
		txtUnidades.setColumns(10);
		txtUnidades.setText(String.valueOf(a.getUnidades()));
		this.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado  = (JButton) e.getSource();
		if(botonPulsado == btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
		}
		else if(botonPulsado == btnComprarArticulo){
			if(!VentanaPrincipal.inicioSesion)
				JOptionPane.showMessageDialog(null, "Primero tienes que iniciaar sesi�n", "ERROR!!", JOptionPane.ERROR_MESSAGE);
			else{
				int unidades=Integer.parseInt(JOptionPane.showInputDialog(null, "�Cu�ntas unidades quieres?"));
				if(a.getUnidades()<unidades){
					JOptionPane.showMessageDialog(null, "Lo sentimos pero no hay suficientes unidades", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Compra c = new Compra(a.getCodigo(), VentanaPrincipal.dniCliente, unidades, unidades*a.getPrecio());
					VentanaCliente.aniadirCompraAlCarrito(c);
					JOptionPane.showMessageDialog(null, "Art�culo a�adido al carrito", "OK!!", JOptionPane.INFORMATION_MESSAGE);
					VentanaPrincipal.bd.modificarUnidadesArticulo(a.getCodigo(), unidades);
				}
			}
		}

	}
}