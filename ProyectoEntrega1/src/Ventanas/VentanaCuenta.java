package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class VentanaCuenta extends JFrame implements ActionListener {

	private JPanel contentPane , panelSur, panelNorte;
	private JTextField txtNomUsuario;
	private JLabel lblBienvenidoAModa, lblNombreUsuario,lblContraseña;
	private JButton btnRegistrate,btnCancelar;
	private JFrame ventanaAnterior;
	private JPasswordField pfcontrasenia;
	private JButton btnAceptar;


	public VentanaCuenta(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelSur = new JPanel();
		panelSur.setBounds(5, 5, 422, 27);
		contentPane.add(panelSur);
		panelSur.setLayout(null);

		lblBienvenidoAModa = new JLabel("Bienvenido a moda y complemetos GAM");
		lblBienvenidoAModa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBienvenidoAModa.setBounds(0, 5, 422, 16);
		panelSur.add(lblBienvenidoAModa);

		panelNorte = new JPanel();
		panelNorte.setBounds(5, 213, 422, 35);
		contentPane.add(panelNorte);

		btnRegistrate = new JButton("Registrate");
		btnRegistrate.addActionListener(this);
		panelNorte.add(btnRegistrate);
		panelNorte.add(btnRegistrate);

		btnAceptar = new JButton("Aceptar");
		panelNorte.add(btnAceptar);
		btnAceptar.addActionListener(this);



		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 13));
		panelNorte.add(btnCancelar);
		btnCancelar.addActionListener(this);

		lblNombreUsuario = new JLabel("Introduzca su nombre de usuario");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setBounds(5, 77, 247, 16);
		contentPane.add(lblNombreUsuario);

		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setBounds(5, 145, 247, 16);
		contentPane.add(lblContraseña);

		txtNomUsuario = new JTextField();
		txtNomUsuario.setBounds(284, 74, 116, 22);
		contentPane.add(txtNomUsuario);
		txtNomUsuario.setColumns(10);

		pfcontrasenia = new JPasswordField();
		pfcontrasenia.setBounds(284, 142, 116, 22);
		contentPane.add(pfcontrasenia);
		this.setVisible(true);
	}
	public void campoVacio()
	{
		txtNomUsuario.setText(" ");
		pfcontrasenia.setText(" ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton)e.getSource();
		if(botonPulsado==btnRegistrate)
		{
			this.dispose();
			new VentanaRegistrar(ventanaAnterior);
		}else if(botonPulsado == btnAceptar){
			String s = VentanaPrincipal.bd.obtenerContrasenia(txtNomUsuario.getText());
			boolean existe = VentanaPrincipal.bd.existeCliente(txtNomUsuario.getText());

			if(existe){
				if(s!=null && s.equals(pfcontrasenia.getText())){
					JOptionPane.showMessageDialog(null, "Contraseña correcta", "CORRECTO!!!", JOptionPane.INFORMATION_MESSAGE	);
					campoVacio();
					VentanaPrincipal.inicioSesion=true;
					this.dispose();
					ventanaAnterior.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "INCORRECTO!!!", JOptionPane.ERROR_MESSAGE	);

				}

			}
			else
				JOptionPane.showMessageDialog(null, "Nombre de usuario incorrecto", "INCORRECTO!!!", JOptionPane.ERROR_MESSAGE	);
			

		}else if(botonPulsado==btnCancelar){
			this.dispose();
			new VentanaPrincipal();
		}

	}

}

