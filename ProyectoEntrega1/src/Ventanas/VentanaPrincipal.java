package Ventanas;

import java.awt.BorderLayout;
import BasesDeDatos.BD;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImagingOpException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame implements ActionListener, MouseListener{

	public static BD bd ;
	private JPanel contentPane;
	public Image ImagenFondo;
	public URL fondo;
	private JPanel panelSur, panelNorte, panelCentral, panelOpciones;
	private JButton btnCuenta,btnCarrito;
	private JLabel lblModaYComplementos;
	private JMenuItem mntmNio, mntmHombre, mntmMujer;
	private PanelImagen panelFondo;
	public static boolean inicioSesion=false;

	public static String dniCliente;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {

		panelFondo = new PanelImagen();
		bd = new BD();
		//bd.conectar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		//fondo= this.getClass().getResource("/Imagenes/moda.jpg");
		//ImagenFondo= new ImageIcon(fondo).getImage();

		Container contenedor= getContentPane();
		contenedor.add(panelFondo);
		panelFondo.setLayout(null);

		panelNorte = new JPanel();
		panelNorte.setOpaque(false);
		panelNorte.setBounds(58, 0, 422, 36);
		panelFondo.add(panelNorte);
		panelNorte.setLayout(null);

		panelSur = new JPanel();
		panelSur.setOpaque(false);
		panelSur.setBounds(0, 35, 422, 1);
		panelFondo.add(panelSur);
		panelSur.setLayout(null);
		
		lblModaYComplementos = new JLabel("MODA Y COMPLEMENTOS GAM");
		lblModaYComplementos.setForeground(Color.BLUE);
		lblModaYComplementos.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblModaYComplementos.setBounds(38, 13, 372, 17);
		panelNorte.add(lblModaYComplementos);

		panelOpciones = new JPanel();
		panelOpciones.setOpaque(false);
		panelOpciones.setBackground(UIManager.getColor("ScrollBar.foreground"));
		panelOpciones.setBounds(0, 36, 107, 206);
		panelFondo.add(panelOpciones);
		panelOpciones.setLayout(null);
		
		mntmNio = new JMenuItem("NI\u00D1O");
		mntmNio.setForeground(Color.GRAY);
		mntmNio.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		mntmNio.setOpaque(false);
		JFrame va = this;
		mntmNio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaNinio(va);
				va.dispose();
			}
		});
		mntmNio.setBounds(0, 27, 107, 24);
		panelOpciones.add(mntmNio);
		
		mntmHombre = new JMenuItem("HOMBRE");
		mntmHombre.setForeground(Color.GRAY);
		mntmHombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		mntmHombre.setOpaque(false);
		mntmHombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaHombre(va);
				va.dispose();
				
			}
		});
		mntmHombre.setHorizontalAlignment(SwingConstants.CENTER);
		mntmHombre.setBounds(0, 115, 107, 24);
		panelOpciones.add(mntmHombre);
		
	    btnCuenta = new JButton("Mi Cuenta");
	    btnCuenta.setBounds(475, 0, 97, 25);
	    panelFondo.add(btnCuenta);
	    btnCuenta.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
	    
	    mntmMujer = new JMenuItem("MUJER");
	    mntmMujer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaMujer(va);
				va.dispose();
			}
		});
	    mntmMujer.setBounds(0, 255, 107, 24);
	    panelFondo.add(mntmMujer);
	    mntmMujer.setForeground(Color.GRAY);
	    mntmMujer.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    mntmMujer.setOpaque(false);
	    
	    btnCarrito = new JButton("Mi Carrito");
	    btnCarrito.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
	    btnCarrito.setBounds(475, 33, 97, 25);
	    btnCarrito.addActionListener(this);
	    panelFondo.add(btnCarrito);
	    btnCuenta.addActionListener(this);
		
		this.setVisible(true);
		this.setSize(600, 400);
	}
	public JPanel panel= new JPanel()
	{
		public void paintComponent(Graphics g){
			g.drawImage(ImagenFondo, 0,0, getWidth(),getHeight(), this);

		}
	};
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton)e.getSource();
		
		if(botonPulsado == btnCuenta){
			new VentanaCuenta(this);
		}
		else if(botonPulsado==btnCarrito){
			new VentanaFinalizarCompra(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}
