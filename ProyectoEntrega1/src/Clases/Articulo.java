package Clases;

public class Articulo {
	
	private int codigo;
	private String nombre,ruta,tipo;
	private float precio;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Articulo(int codigo, String nombre, String ruta, String tipo, float precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ruta = ruta;
		this.tipo = tipo;
		this.precio = precio;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", ruta=" + ruta + ", tipo=" + tipo + ", precio="
				+ precio + "]";
	}
	
	

}
