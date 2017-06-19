package ar.com.reduceFatFast.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
public @Data class IngredienteComida {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Ingrediente ingrediente ;
	private Integer cantidad;
	private String unidad;
	
	protected IngredienteComida() {}
	
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
