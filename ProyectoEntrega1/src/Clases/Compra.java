package Clases;

public class Compra {

	private int codigoArticulo;
	private String dniCliente;
	private int unidades;
	private double precioTotal;
	public int getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(int codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	@Override
	public String toString() {
		return "Compra [codigoArticulo=" + codigoArticulo + ", dniCliente=" + dniCliente + ", unidades=" + unidades
				+ ", precioTotal=" + precioTotal + "]";
	}
	public Compra(int codigoArticulo, String dniCliente, int unidades, double d) {
		super();
		this.codigoArticulo = codigoArticulo;
		this.dniCliente = dniCliente;
		this.unidades = unidades;
		this.precioTotal = d;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}
