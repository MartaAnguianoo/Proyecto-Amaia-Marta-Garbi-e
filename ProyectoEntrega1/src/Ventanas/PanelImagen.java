package Ventanas;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Clase que se ocupa de poner de fondo una imagen
 * @author Usuario
 *
 */
public class PanelImagen extends javax.swing.JPanel {
	public PanelImagen(){
		this.setSize(400,280);
	}
	@Override
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/moda2.jpg"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}