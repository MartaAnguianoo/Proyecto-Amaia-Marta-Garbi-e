package BasesDeDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JPasswordField;

/**
 * Clase que se ocupa de administrar los datos  
 * @author Usuario
 *
 */

public class BD {

	private Connection connection;
	private static Statement stmt;

	public BD()
	{
		conectar();
	}

	/**
	 * Metodo que conecta a la base de datos
	 */
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


	/**
	 * Metodo que desconecta de la base de datos
	 */
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

	/**
	 * Metodo que crea sentencia
	 */
	public void crearSentencia()
	{
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Metodo que cierra sentencia
	 */
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que dado un email comprueba si existe en la base de datos
	 * @param email : email del cliente
	 * @return
	 */
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

	/**
	 * Metodo que inserta los datos de un cliente
	 * @param d : dni del cliente
	 * @param n : nombre del cliente
	 * @param nc : numero de cuenta del cliente
	 * @param e : email del cliente
	 * @param c . contrasenia del cliente
	 */
	public void insertarCliente( String d, String n, String nc,String e, String c){
		String s = "INSERT INTO cliente(Dni, Nombre, NumeroDeCuenta,Email, Contrasenia) VALUES ('"+d+"','"+n+"','"+nc+"','"+e+"','"+c+"')";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	/**
	 * Metodo que inserta un articulo en la base de datos
	 * @param codigo : codigo del articulo
	 * @param nombre : tipo del articulo (falda,pantalon, zapato..)
	 * @param precio :  precio del articulo
	 */
	public void insertarArticulo(int codigo, String nombre, double precio){
		String s = "INSERT INTO articulo(Codigo,Nombre, Precio) VALUES ("+codigo+",'"+nombre+"'" +precio+")";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Metodo que obtiene las rutas de las fotos
	 * @param nombre : nombre de la foto
	 * @param tipo : tipo de la foto(hombre,niño,mujer)
	 * @return
	 */
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
	/**
	 * Metodo que obtiene la contraseña del cliente
	 * @param nom : nombre del cliente
	 * @return
	 */
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




}
