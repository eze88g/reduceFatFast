package ar.com.reduceFatFast.model;

import java.util.List;

public class Comida {
	
	private String oid;
	private String nombre;
	private List<Ingrediente> ingredientes; //TODO: Donde incluir la cantidad??
	private List<Integer> cantidades;
	
	public Comida(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void agregarIngrediente (Ingrediente unIngrediente, int unaCantidad){
		ingredientes.add(unIngrediente);
		cantidades.add(unaCantidad);
	}
}
