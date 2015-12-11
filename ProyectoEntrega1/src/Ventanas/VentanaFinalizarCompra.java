package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Compra;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class VentanaFinalizarCompra extends JFrame implements ActionListener{

	private JPanel contentPane,panelNorte, panelSur, panelCentro;
	private JButton btnRealizarPago, btnVolver;
	private JTextPane txtDatosCompra;
	private JFrame ventanaAnterior;

	
	private void cargarCompra(){
		
		String texto = "";
		double total=0;
		
		for(int i=0;i<VentanaCliente.carrito.size();i++){
			Compra c = VentanaCliente.carrito.get(i);
			texto = texto + "CODIGO: "+ c.getCodigoArticulo() + " UNIDADES: " + c.getUnidades() + " PRECIO TOTAL: "+ c.getPrecioTotal() + "€\n";
			total = total + c.getPrecioTotal();
		}
		
		texto = texto + "TOTAL A PAGAR: "+ total + "€";
		
		txtDatosCompra.setText(texto);
	}
	/**
	 * Create the frame.
	 */
	public VentanaFinalizarCompra(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		btnRealizarPago = new JButton("REALIZAR PAGO");
		btnRealizarPago.addActionListener(this);
		panelSur.add(btnRealizarPago);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		txtDatosCompra = new JTextPane();
		txtDatosCompra.setBounds(26, 11, 371, 189);
		panelCentro.add(txtDatosCompra);
		cargarCompra();
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if(botonPulsado == btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
			
		}
		else if(botonPulsado == btnRealizarPago){
			//VentanaPrincipal.bd.insertarCompra(VentanaCliente.carrito);
			//JOptionPane.showMessageDialog(null, "Compra realizada con éxito", "OK!!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new VentanaPagar(ventanaAnterior);
		}
		
		
		
	}
}
