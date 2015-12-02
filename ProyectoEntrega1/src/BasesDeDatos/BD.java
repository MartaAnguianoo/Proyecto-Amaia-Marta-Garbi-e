package BasesDeDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JPasswordField;

import Clases.Articulo;
import Clases.Compra;



public class BD {

	private Connection connection;
	private static Statement stmt;

	public BD()
	{
		conectar();
	}

	public void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:TiendaOnline.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}


	public void desconectar()
	{
		try {
			cerrarSentencia();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crearSentencia()
	{
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean existeCliente(String email){

		boolean existe=false;

		String s = "SELECT * FROM cliente WHERE Email='"+email+"'";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(s);

			if(rs.next())
				existe=true;
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return existe;
	}

	public void insertarCliente( String d, String n, String nc,String e, String c){
		String s = "INSERT INTO cliente(Dni, Nombre, NumeroDeCuenta,Email, Contrasenia) VALUES ('"+d+"','"+n+"','"+nc+"','"+e+"','"+c+"')";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}



	public void insertarArticulo(int codigo, String nombre, double precio){
		String s = "INSERT INTO articulo(Codigo,Nombre, Precio) VALUES ("+codigo+",'"+nombre+"'" +precio+")";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void insertarCompra(String dni, int codigo , String fecha){
		String s = "INSERT INTO Matricula(CodigoArticulo,DniCliente, Fecha) VALUES('"+codigo+"',"+dni+"',"+fecha +")";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static LinkedList<String> obtenerRutasFotosNiniosJerseys(){
		String s= "SELECT ruta FROM articulo";
		LinkedList<String> lRutasNinios = new LinkedList<String>();

		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				lRutasNinios.add(rs.getString("ruta"));
				System.out.println("Ruta:" + rs.getString("ruta"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lRutasNinios;

	}

	public static LinkedList<String> obtenerRutasFotosHombres(){
		String s= "SELECT ruta FROM articulo";
		LinkedList<String> lRutasHombres = new LinkedList<String>();

		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				lRutasHombres.add(rs.getString("ruta"));
				System.out.println("Ruta:" + rs.getString("ruta"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lRutasHombres;

	}

	public static LinkedList<String> obtenerRutasFotos(String nombre, String tipo){
		String s= "SELECT ruta FROM articulo WHERE Nombre='"+nombre+"' AND tipo='"+tipo+"'";
		LinkedList<String> lRutasNinios = new LinkedList<String>();

		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				lRutasNinios.add(rs.getString("ruta"));
				System.out.println("Ruta:" + rs.getString("ruta"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lRutasNinios;

	}
	public String obtenerContrasenia (String nom){

		String contrasenia = null;
		String s = "SELECT Contrasenia FROM Cliente	WHERE Email='"+nom+"'";
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next())
				contrasenia = rs.getString("Contrasenia");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contrasenia;
	}

	public Articulo obtenerArticulo(String ruta){
		String s = "SELECT * FROM articulo WHERE ruta='"+ruta+"'";
		ResultSet rs;
		Articulo a = null;
		try {
			rs = stmt.executeQuery(s);
			a = new Articulo(rs.getInt("codigo"),rs.getString("nombre"),rs.getString("ruta"),rs.getString("tipo"),rs.getFloat("precio"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

	public void insertarCompra(LinkedList<Compra> carrito){

		for(int i=0;i<carrito.size();i++){
			Compra c = carrito.get(i);
			String s = "INSERT INTO compra(codigo,dni,unidades,precioTotal) VALUES('" + c.getCodigoArticulo() +"','" + c.getDniCliente()+ "',"+ c.getUnidades()+","+ c.getPrecioTotal()+")";
			try {
				stmt.executeUpdate(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}
