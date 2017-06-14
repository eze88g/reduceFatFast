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

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
}
