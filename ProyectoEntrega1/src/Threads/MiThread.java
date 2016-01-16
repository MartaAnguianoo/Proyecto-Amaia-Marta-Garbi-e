package Threads;

import java.awt.Color;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Ventanas.VentanaMiThread;

/**
 * Esta clase es un hilo que simula que paga una compra 
 * @author Amaia, Marta y Garbiñe
 *
 */

public class MiThread extends Thread{
	private JFrame va1,va2;
	/**
	 * Constructor con parametros
	 * @param va
	 */
	public MiThread(JFrame va1, JFrame va2){
		super();
		this.va1=va1;
		this.va2=va2;
	}
	
	
	public void run(){
		VentanaMiThread vt = new VentanaMiThread();
		for(int i=0;i<vt.aLabels.length;i++){

			vt.aLabels[i].setVisible(true);
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		vt.dispose();
		JOptionPane.showMessageDialog(null, "Compra realizada con éxito", "OK!!", JOptionPane.INFORMATION_MESSAGE);
		va1.dispose();
		va2.setVisible(true);
	}

}

