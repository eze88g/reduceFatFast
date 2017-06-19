package ar.com.reduceFatFast.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Ingrediente {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	String name ;
	int calorias;
	
	public Ingrediente(String name, int calorias) {
		super();
		this.name = name;
		this.calorias = calorias;
	}
	
	protected Ingrediente(){}
	
}

