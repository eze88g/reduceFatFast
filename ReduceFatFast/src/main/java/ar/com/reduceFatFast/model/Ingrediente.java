package ar.com.reduceFatFast.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
public @Data class Ingrediente {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name ;
	private Integer cantidad;
	private String unidad;
	//private Comida comida;
	
	public Ingrediente(String name, int cantidad, String unidad) {
		super();
		this.name = name;
		this.setCantidad(cantidad);
		this.setUnidad(unidad);
	}
	
	protected Ingrediente(){}
	
}

