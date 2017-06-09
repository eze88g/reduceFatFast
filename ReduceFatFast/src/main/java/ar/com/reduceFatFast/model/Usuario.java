package ar.com.reduceFatFast.model;

import java.sql.Date;

public class Usuario {
	private String oid;
	String nombre;
	int dni;
	
	public Usuario(String nombre, int dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
}
