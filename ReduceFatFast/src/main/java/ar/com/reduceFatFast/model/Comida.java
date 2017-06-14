package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.List;

public class Comida {
	
	private String oid;
	private String nombre;
	private List<IngredienteComida> ingredientes = new ArrayList<IngredienteComida>(); //TODO: Donde incluir la cantidad??
	
	public Comida(String nombre) {
		super();
		this.nombre = nombre;
	}

	
	
	public String getOid() {
		return oid;
	}



	public void setOid(String oid) {
		this.oid = oid;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<IngredienteComida> getIngredientes() {
		return ingredientes;
	}



	public void setIngredientes(List<IngredienteComida> ingredientes) {
		this.ingredientes = ingredientes;
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
