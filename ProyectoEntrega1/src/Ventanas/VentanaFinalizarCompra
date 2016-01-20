package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Clases.Articulo;
import Clases.Compra;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

/**
 * Ventana donde se ve el resumen de la compra final y el total a pagar
 * 
 * @author Usuario
 *
 */
public class VentanaFinalizarCompra2 extends JFrame implements ActionListener{

	private JPanel contentPane,panelSur,panelCentro, panelNorte;
	private JTable tablaCarrito;
	private JFrame ventanaAnterior;
	private JButton btnVolver,btnFinalizarCompra;
	private JLabel lblTotalCompra,lblDatosDeLaCompra;
	private JScrollPane scrollTabla;
	
	private static DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
	static {
		rendererCentrado.setHorizontalAlignment( JLabel.CENTER );
		rendererCentrado.setBackground( Color.GREEN );
		
	}
	/**
	 * Create the frame.
	 */
	public VentanaFinalizarCompra2(JFrame va) {
		ventanaAnterior=va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		lblDatosDeLaCompra = new JLabel("DATOS DE LA COMPRA");
		lblDatosDeLaCompra.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDatosDeLaCompra.setForeground(new Color(0, 0, 255));
		panelNorte.add(lblDatosDeLaCompra);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
		btnFinalizarCompra.addActionListener(this);
		panelSur.add(btnFinalizarCompra);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		panelSur.add(btnVolver);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		tablaCarrito = new JTable();
		tablaCarrito.setBounds(12, 13, 398, 138);
		DefaultTableModel dtm=(DefaultTableModel)tablaCarrito.getModel();
		String titulos[] = {"CODIGO","UNIDADES","PRECIO TOTAL"};
		for(int i=0;i<titulos.length;i++)
			dtm.addColumn(titulos[i]);
		double totalCompra=0;
		for(int i=0;i<VentanaCliente.carrito.size();i++){
			Compra c = VentanaCliente.carrito.get(i);
			totalCompra=totalCompra+c.getPrecioTotal();
			Object fila[] = {c.getCodigoArticulo(),c.getUnidades(), c.getPrecioTotal()};
			dtm.addRow(fila);
		}
		tablaCarrito.setModel(dtm);
		tablaCarrito.getColumn("PRECIO TOTAL").setCellRenderer(rendererCentrado);
		tablaCarrito.setEnabled(false);
		scrollTabla = new JScrollPane(tablaCarrito);
		scrollTabla.setBounds(12, 13, 398, 138);
		panelCentro.add(scrollTabla);
		
		lblTotalCompra = new JLabel("TOTAL COMPRA: ");
		lblTotalCompra.setText(lblTotalCompra.getText()+ totalCompra+ " €");
		lblTotalCompra.setBounds(12, 164, 398, 16);
		panelCentro.add(lblTotalCompra);
		this.setVisible(true);
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton botonPulsado = (JButton) e.getSource();
			if(botonPulsado==btnFinalizarCompra){
				this.dispose();
				new VentanaPagar(ventanaAnterior);
			}
			else{
				this.dispose();
				ventanaAnterior.setVisible(true);
			}
		}
}
