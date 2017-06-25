package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.Data;

@Entity
public @Data class Comida {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Version
	private int version;
	private String nombre;
	
	private long cantidadCalorias;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="COMIDA_ID")
	private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	protected Comida(){
		this.setCantidadCalorias(0);
	}
	
	public Comida(String nombre) {
		super();
		this.nombre = nombre;
		this.setIngredientes(new ArrayList<Ingrediente>());
	}

	public void agregarIngrediente (String nombre, Integer cantidad, String unidad){
		Ingrediente ingrediente = new Ingrediente(nombre, cantidad, unidad);
		this.getIngredientes().add(ingrediente);
	}
	
	public enum ComidaDelDia {
	    DESAYUNO,
	    ALMUERZO,
	    MERIENDA,
	    CENA;
	}
}
