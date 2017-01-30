package edu.itla.gestoralumnos.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import edu.itla.gestoralumnos.entidades.Alumno;

public class Consulta {
	
	private static Consulta instancia;
	private Conexion conexion;
	private Statement enunciado;
	private PreparedStatement ps;
	
	public static Consulta getInstancia() throws Exception  {
		return instancia == null ? instancia = new Consulta() : instancia;
	}
	
	private Consulta() throws Exception {
		conexion = Conexion.getInstancia();
		enunciado = conexion.getConexion().createStatement();
	}
	
	public ResultSet hacerConsulta() {
		
		ResultSet rs = null;
		
		try {
			rs = enunciado.executeQuery("SELECT clave, nombre, apellidos, "
					+ "edad, calle, numero, codigo FROM alumnos");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}
	
	public void insertarCampos(Alumno alumno) throws Exception {
		
		ps = conexion.getConexion().prepareStatement("INSERT INTO alumnos VALUES(?,?,?,?,?,?,?)");
		ps.setString(1, alumno.getClave());
		ps.setString(2, alumno.getNombre());
		ps.setString(3, alumno.getApellidos());
		ps.setInt(4, alumno.getEdad());
		ps.setString(5, alumno.getCalle());
		ps.setInt(6, alumno.getNumero());
		ps.setString(7, alumno.getCodigo());
		ps.execute();
	}
	
	public void cambiarCampos(Alumno alumno) throws Exception {
		
		ps = conexion.getConexion().prepareStatement("UPDATE alumnos set nombre = ?, "
				+ " apellidos = ?, edad = ?, calle = ?, "
				+ " numero = ?, codigo = ? WHERE clave = ?");
		ps.setString(1, alumno.getNombre());
		ps.setString(2, alumno.getApellidos());
		ps.setInt(3, alumno.getEdad());
		ps.setString(4, alumno.getCalle());
		ps.setInt(5, alumno.getNumero());
		ps.setString(6, alumno.getCodigo());
		ps.setString(7, alumno.getClave());
		ps.execute();
	}
	
	public void eliminarCampos(String clave) throws Exception {
		
		ps = conexion.getConexion().prepareStatement("DELETE FROM alumnos WHERE clave = ?");
		ps.setString(1, clave);
		ps.execute();
	}
}
