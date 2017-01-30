package edu.itla.gestoralumnos.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private Connection conexion;
	private static Conexion instancia;
	
	/*public static Conexion getInstancia() throws Exception {
		//return instancia == null ? instancia = new Conexiona() : instancia;
	}*/
	
	private Conexion() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/gestor_alumnos?user=root&password=");
	}

	public Connection getConexion() {
		return conexion;
	}
	
}
