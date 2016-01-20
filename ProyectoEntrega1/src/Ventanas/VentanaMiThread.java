package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.SystemColor;

/**
 * Ventana que simula un hilo procesando la compra 
 * @author Amaia, Marta y Garbiñe
 *
 */
public class VentanaMiThread extends JFrame {

	private JPanel contentPane, panelSur ;
	public JPanel panelCentro;
	public JLabel aLabels[], lblCargando;

	/**
	 * Create the frame.
	 */
	public VentanaMiThread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 300, 300);
		setBounds(100, 100, 450,300);
		//100 100 450 300
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setSize(250, 200);
	
		panelSur = new JPanel();
		panelSur.setBackground(SystemColor.controlHighlight);
		contentPane.add(panelSur, BorderLayout.SOUTH);

		lblCargando = new JLabel("PROCESANDO LA COMPRA...");
		lblCargando.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCargando.setForeground(new Color(102, 0, 255));
		panelSur.add(lblCargando);

		panelCentro = new JPanel();
		panelCentro.setBackground(SystemColor.controlHighlight);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		
		aLabels = new JLabel[10];
		int x=10;
		for(int i=0;i<aLabels.length;i++){
			aLabels[i]=new JLabel(".");
			aLabels[i].setVisible(false);
			aLabels[i].setBackground(Color.BLUE);
			aLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			aLabels[i].setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			aLabels[i].setBounds(x, 50, 20, 20);
			x=x+20;
			panelCentro.add(aLabels[i]);

		}
		this.setVisible(true);
	}
}
