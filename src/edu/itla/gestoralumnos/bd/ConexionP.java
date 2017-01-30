package edu.itla.gestoralumnos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.itla.gestoralumnos.entidades.Alumno;

public class ConexionP {

	private static Conexion instancia;
	private Connection conexion;
	
	private ConexionP() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:erick.db");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Conexion getInstancia() {
		
		return instancia == null ? instancia = new Conexion() : instancia;
	}
	
	public Connection getConexion() {
		return conexion;
	}
	
	public ArrayList<Alumno> getAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from alumnos");
			
			while (rs.next()) {
				alumnos.add(new Alumno(rs.getString("clave"), rs.getString("nombre"), rs.getString("apellidos"), 
						rs.getInt("edad"), rs.getString("calle"), rs.getInt("numero"), rs.getString("codigo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alumnos;
	}
}
