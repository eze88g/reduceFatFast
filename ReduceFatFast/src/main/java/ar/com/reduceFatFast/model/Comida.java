package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public @Data class Comida {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nombre;
	@OneToMany
	private List<IngredienteComida> ingredientes = new ArrayList<IngredienteComida>(); //TODO: Donde incluir la cantidad??
	
	protected Comida(){}
	
	public Comida(String nombre) {
		super();
		this.nombre = nombre;
		this.ingredientes = new ArrayList<>();
	}

	public void agregarIngrediente (Ingrediente unIngrediente, int unaCantidad, String unaUnidad){
		IngredienteComida ingredienteComida = new IngredienteComida(unIngrediente, unaCantidad, unaUnidad);
		ingredientes.add(ingredienteComida);
	}
	
	public enum ComidaDelDia {
	    DESAYUNO,
	    ALMUERZO,
	    MERIENDA,
	    CENA;
	}
}
