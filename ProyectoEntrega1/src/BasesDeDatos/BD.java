package BasesDeDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JPasswordField;

import Clases.Articulo;
import Clases.Cliente;
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
			/*C:\\Users\\Usuario\\Documents\\Ingenieria informática\\2ºCurso\\Pen 21-11-15\\Programación III\\Ejercicios\\Proyecto\\*/
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

	public void insertarCliente( String d, String n, String nc,String e, String c,String dir){
		String s = "INSERT INTO cliente(Dni, Nombre, NumeroDeTarjeta,Email, Contrasenia,Direccion) VALUES ('"+d+"','"+n+"','"+nc+"','"+e+"','"+c+"','"+dir+"')";
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

		Date d = new Date(System.currentTimeMillis());
		String fecha = d.toString();
		for(int i=0;i<carrito.size();i++){
			Compra c = carrito.get(i);
			String s = "INSERT INTO compra(CodigoArticulo,DniCliente,Unidades,PrecioTotal,Fecha) VALUES('" + c.getCodigoArticulo() +"','" + c.getDniCliente()+ "',"+ c.getUnidades()+","+ c.getPrecioTotal()+",'"+fecha+"')";
			try {
				stmt.executeUpdate(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String obtenerDni(String email, String con){
		String s = "SELECT Dni FROM cliente WHERE Email='"+email+"' AND Contrasenia='"+con+"'";
		String dni="";
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next())
				dni=rs.getString("Dni");
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dni;
	}
	public Cliente obtenerDatos( String dni){
		String s = "SELECT * FROM cliente WHERE Dni='"+dni+"'";
		Cliente c=null;
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next())
				c = new Cliente(rs.getString("Nombre"),rs.getString("Dni"),rs.getInt("NumeroDeTarjeta"),rs.getString("Direccion"),rs.getString("Email"),rs.getString("Contrasenia"));
				
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
		
	}


}
