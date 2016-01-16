package Ventanas;

import java.util.LinkedList;

import Clases.Articulo;
import Clases.Compra;

/**
 * Esta clase 
 * @author Amaia, Marta y Garbiñe
 *
 */
public class VentanaCliente {
	public static LinkedList<Compra> carrito = new LinkedList<Compra> ();
	
	/**
	 * Metodo que dado un codigo busca dicho articulo
	 * @param codigo
	 * @return
	 */
	public static int buscarArticulo(int codigo){
		boolean enc=false;
		int pos=0;
		while(!enc && pos<carrito.size()){
			if(carrito.get(pos).getCodigoArticulo()==codigo)
				enc=true;
			else
				pos++;
		}
		if(enc)
			return pos;
		else return -1;
	}
	
	/**
	 * Metodo que dado una compra lo añade al carrito
	 * @param c
	 */
	public static void aniadirCompraAlCarrito(Compra c){
		int pos= buscarArticulo(c.getCodigoArticulo());
		if(pos==-1)
			carrito.add(c);
		else{
			Compra c2=carrito.get(pos);
			c2.setUnidades(c2.getUnidades()+c.getUnidades());
			c2.setPrecioTotal(c2.getPrecioTotal()+c.getPrecioTotal());
			carrito.set(pos, c2);
		}
	}
}
