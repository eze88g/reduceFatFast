package ar.com.reduceFatFast.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import lombok.Data;

@Inheritance
@DiscriminatorColumn(name="USER_TYPE")
@Table(name="USUARIO")
@Entity
public @Data class Usuario {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	String nombre;
	int dni;
	
	protected Usuario(){}
	
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
