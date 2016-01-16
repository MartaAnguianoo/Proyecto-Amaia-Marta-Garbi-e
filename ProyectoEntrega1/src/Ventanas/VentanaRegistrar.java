package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import BasesDeDatos.BD;

/**
 * Ventana donde se registra y se identifica un cliente
 * @author Amaia, Marta y Garbiñe
 *
 */
public class VentanaRegistrar extends JFrame implements ActionListener {

	private JPanel contentPane, panelCentro, panelIzquierda,panelDerecha, panelNorte;
	private JTextField txtEmail,txtDni,txtNombre, txtNCuenta;
	private JPasswordField psContrasenia;
	private JButton btnVolver, btnAceptar;
	private JLabel lblIdentificateregistrate,lblCuentaDeUsuario,lblEmail,lblContrasenia,lblDatosDeContacto,lblNombre,lblDni,lblNCuenta;
	private JFrame ventanaAnterior;
	private JLabel lblDireccion;
	private JTextField txtDireccion;

	public VentanaRegistrar(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelCentro = new JPanel();
		panelCentro.setBounds(5, 5, 459, 24);
		contentPane.add(panelCentro);

		lblIdentificateregistrate = new JLabel("IDENTIFICATE/REGISTRATE");
		panelCentro.add(lblIdentificateregistrate);

		panelNorte = new JPanel();
		panelCentro.add(panelNorte);
		panelNorte.setLayout(new BorderLayout(0, 0));

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(100, 269, 137, 23);
		contentPane.add(btnAceptar);

		btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(249, 269, 137, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(this);

		panelIzquierda = new JPanel();
		panelIzquierda.setBounds(5, 40, 219, 216);
		contentPane.add(panelIzquierda);
		panelIzquierda.setLayout(null);


		lblCuentaDeUsuario = new JLabel("CUENTA DE USUARIO");
		lblCuentaDeUsuario.setBounds(21, 0, 164, 14);
		panelIzquierda.add(lblCuentaDeUsuario);

		lblEmail = new JLabel("Email : ");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(21, 43, 66, 14);
		panelIzquierda.add(lblEmail);

		lblContrasenia = new JLabel("Contrase\u00F1a : ");
		lblContrasenia.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasenia.setBounds(21, 94, 78, 14);
		panelIzquierda.add(lblContrasenia);

		txtEmail = new JTextField();
		txtEmail.setBounds(97, 40, 110, 20);
		panelIzquierda.add(txtEmail);
		txtEmail.setColumns(10);

		psContrasenia = new JPasswordField();
		psContrasenia.setBounds(97, 91, 110, 20);
		panelIzquierda.add(psContrasenia);

		panelDerecha = new JPanel();
		panelDerecha.setBounds(236, 40, 228, 216);
		contentPane.add(panelDerecha);
		panelDerecha.setLayout(null);

		lblDatosDeContacto = new JLabel("DATOS DE CONTACTO");
		lblDatosDeContacto.setBounds(10, 0, 184, 14);
		panelDerecha.add(lblDatosDeContacto);

		lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(10, 27, 59, 14);
		panelDerecha.add(lblNombre);

		lblDni = new JLabel("Dni :");
		lblDni.setBounds(10, 79, 74, 14);
		panelDerecha.add(lblDni);

		lblNCuenta = new JLabel("N\u00BA Tarjeta : ");
		lblNCuenta.setBounds(10, 127, 74, 14);
		panelDerecha.add(lblNCuenta);

		txtNombre = new JTextField();
		txtNombre.setBounds(79, 27, 115, 20);
		panelDerecha.add(txtNombre);
		txtNombre.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(79, 76, 115, 20);
		panelDerecha.add(txtDni);
		txtDni.setColumns(10);

		txtNCuenta = new JTextField();
		txtNCuenta.setBounds(79, 124, 115, 20);
		panelDerecha.add(txtNCuenta);
		txtNCuenta.setColumns(10);
		
		lblDireccion = new JLabel("Direccion :");
		lblDireccion.setBounds(10, 172, 64, 16);
		panelDerecha.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(78, 169, 116, 22);
		panelDerecha.add(txtDireccion);
		txtDireccion.setColumns(10);

		this.setVisible(true);
	}
	public void campoVacio()
	{
		txtDni.setText("");
		txtEmail.setText("");
		txtNCuenta.setText("");
		txtNombre.setText("");
		psContrasenia.setText("");
		txtDireccion.setText("");
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton botonPulsado = (JButton)e.getSource();
		
		if(botonPulsado == btnAceptar){
			if(txtNombre.getText().equals("") || txtDni.getText().equals("") || txtNCuenta.getText().equals("") || txtDireccion.getText().equals("")){
				JOptionPane.showMessageDialog(null, "ERROR, faltan datos por rellenar", "ERROR!!! ", JOptionPane.ERROR_MESSAGE);
	
			}else if(BD.existeCliente(txtEmail .getText())){
				JOptionPane.showMessageDialog(null, "ERROR, el usuario ya se ha registrado con este email", "ERROR!!! ", JOptionPane.ERROR_MESSAGE);

				
			}else{
				JOptionPane.showMessageDialog(null, "ENHORABUENA, el usuario ya se ha registrado", "ENHORABUENA!!! ", JOptionPane.INFORMATION_MESSAGE);
				VentanaPrincipal.bd.insertarCliente(txtDni.getText(),txtNombre.getText(),txtNCuenta.getText(), txtEmail.getText(), psContrasenia.getText(),txtDireccion.getText());
				campoVacio();

			}
		}else if(botonPulsado ==btnVolver){
			this.dispose();
			new VentanaPrincipal();
		}
	}
}
