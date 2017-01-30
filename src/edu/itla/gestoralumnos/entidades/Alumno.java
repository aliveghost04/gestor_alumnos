package edu.itla.gestoralumnos.entidades;

public class Alumno {

	private String clave;
	private String nombre;
	private String apellidos;
	private int edad;
	private String calle;
	private int numero;
	private String codigo;

	public Alumno(String clave, String nombre, String apellidos, int edad,
			String calle, int numero, String codigo) {
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.calle = calle;
		this.numero = numero;
		this.codigo = codigo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}