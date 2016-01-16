package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Clases.Articulo;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import java.awt.Color;

/**
 * Ventana donde se elige la ropa de niño que se quiere comprar
 * @author Amaia, Marta y Garbiñe
 *
 */
public class VentanaNinio extends JFrame implements MouseListener,ActionListener{

	private JPanel contentPane, panelNorte, panelSur, panelFotos;
	private JFrame ventanaAnterior;
	private JButton btnVolver;
	private JPanel panelOeste;
	private JPanel panelCentro;
	private JMenuItem mntmChaquetasJerseys;
	private JMenuItem mntmPantalonesFaldas;
	private JMenuItem mntmZapatos;
	private JLabel lblFoto;
	
	
	
	private void cargarFotosNiño(){
		
			String ruta = "ImagenesNiño\\niño.jpg";

			ImageIcon im = new ImageIcon(ruta);
			im.setDescription(ruta);
			lblFoto = new JLabel(im);
			panelCentro.add(lblFoto);
		}
	
	private void cargarFotos(String nombre, String tipo){
		panelFotos.removeAll();
		LinkedList<String> lFotos = VentanaPrincipal.bd.obtenerRutasFotos(nombre, tipo);
		for(int i=0;i<lFotos.size();i++){
			String ruta = lFotos.get(i);
			ImageIcon im = new ImageIcon(ruta);
			im.setDescription(ruta);
			JLabel lblFoto = new JLabel(im);
			panelFotos.add(lblFoto);
		}
	}

	/**
	 * Create the frame.
	 */
	public VentanaNinio(JFrame va) {
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
		
		panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		panelOeste.setLayout(new GridLayout(0, 1, 0, 0));
		
		mntmPantalonesFaldas = new JMenuItem("Pantalones & Faldas");
		mntmPantalonesFaldas.setForeground(new Color(64, 224, 208));
		mntmPantalonesFaldas.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		mntmPantalonesFaldas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelCentro.removeAll();
				panelCentro.add(panelFotos);
				cargarFotos("PF", "Niño");
				panelFotos.updateUI();
			}
		});
		panelOeste.add(mntmPantalonesFaldas);
		
		mntmChaquetasJerseys = new JMenuItem("Chaquetas & Jerseys");
		mntmChaquetasJerseys.setForeground(new Color(72, 61, 139));
		mntmChaquetasJerseys.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		panelOeste.add(mntmChaquetasJerseys);
		mntmChaquetasJerseys.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelCentro.removeAll();
				panelCentro.add(panelFotos);
				cargarFotos("CJ", "Niño");
				panelFotos.updateUI();
			}
		});
		
		mntmZapatos = new JMenuItem("Zapatos");
		mntmZapatos.setForeground(new Color(0, 0, 128));
		mntmZapatos.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		panelOeste.add(mntmZapatos);
		mntmZapatos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelCentro.removeAll();
				panelCentro.add(panelFotos);
				System.out.println("cargando fotod");
				cargarFotos("Z", "Niño");
				panelFotos.updateUI();
			}
		});
		
		panelCentro = new JPanel();
		panelCentro.addMouseListener(this);
		JScrollPane scrollCentro = new JScrollPane(panelCentro);
		contentPane.add(scrollCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(1, 3, 0, 0));
		cargarFotosNiño();
		panelFotos = new JPanel();
		panelFotos.setLayout(new GridLayout(0, 2));
		this.setVisible(true);
		this.setSize(775,525);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = panelFotos.getMousePosition();
		JLabel foto = (JLabel)panelFotos.getComponentAt(p);
		ImageIcon im = (ImageIcon)foto.getIcon();
		String ruta = im.getDescription();
		Articulo a = VentanaPrincipal.bd.obtenerArticulo(ruta);
		if(a.getUnidades()==0){
			JOptionPane.showMessageDialog(null, "Lo sentimos pero este artículo está agotado");
		}
		else{
			this.dispose();
			new VentanaDatoRopa(this, ruta);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if(botonPulsado == btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
		}
	}
}
