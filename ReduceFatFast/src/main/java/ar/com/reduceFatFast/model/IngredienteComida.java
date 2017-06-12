package ar.com.reduceFatFast.model;

public class IngredienteComida {
	private Ingrediente ingrediente ;
	private Integer cantidad;
	private String unidad;
	
	public IngredienteComida(Ingrediente ingrediente, Integer cantidad, String unidad) {
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}
	
}
