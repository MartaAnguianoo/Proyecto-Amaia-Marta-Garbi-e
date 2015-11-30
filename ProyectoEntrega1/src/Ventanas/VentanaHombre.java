package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;

/**
 * Ventana donde se ven los articulos de los hombres
 * @author Usuario
 *
 */
public class VentanaHombre extends JFrame implements MouseListener,ActionListener{

	private JPanel contentPane, panelNorte, panelSur, panelFotos;
	private JFrame ventanaAnterior;
	private JButton btnVolver;
	private JPanel panelOeste;
	private JPanel panelCentro;
	private JMenuItem mntmChaquetasJerseys;
	private JMenuItem mntmPantalones;
	private JMenuItem mntmZapatos;
	private JLabel lblFoto;
	
	

	private void cargarFotosHombre(){
		
			String ruta = "ImagenesHombre\\modahombre.jpg";
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
	public VentanaHombre(JFrame va) {
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
		
		mntmPantalones = new JMenuItem("Pantalones");
		mntmPantalones.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		mntmPantalones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelCentro.removeAll();
				panelCentro.add(panelFotos);
				cargarFotos("P", "Hombre");
				panelFotos.updateUI();
			}
		});
		panelOeste.add(mntmPantalones);
		
		mntmChaquetasJerseys = new JMenuItem("Chaquetas & Jerseys");
		panelOeste.add(mntmChaquetasJerseys);
		mntmChaquetasJerseys.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelCentro.removeAll();
				panelCentro.add(panelFotos);
				cargarFotos("CJ", "Hombre");
				panelFotos.updateUI();
			}
		});
		
		mntmZapatos = new JMenuItem("Zapatos");
		mntmZapatos.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		panelOeste.add(mntmZapatos);
		mntmZapatos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelCentro.removeAll();
				panelCentro.add(panelFotos);
				cargarFotos("Z", "Hombre");
				panelFotos.updateUI();
			}
		});
		
		panelCentro = new JPanel();
		panelCentro.addMouseListener(this);
		JScrollPane scrollCentro = new JScrollPane(panelCentro);
		contentPane.add(scrollCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(1, 3, 0, 0));
		cargarFotosHombre();
		panelFotos = new JPanel();
		panelFotos.setLayout(new GridLayout(2, 4));
		this.setVisible(true);
		this.setSize(775,525);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = panelCentro.getMousePosition();
		JLabel foto = (JLabel)panelCentro.getComponentAt(p);
		ImageIcon im = (ImageIcon)foto.getIcon();
		String ruta = im.getDescription();
		this.dispose();
		//new VentanaNinio(this,ruta);
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



