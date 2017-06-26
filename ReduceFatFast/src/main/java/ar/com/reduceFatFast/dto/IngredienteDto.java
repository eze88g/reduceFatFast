/**
 * 
 */
package ar.com.reduceFatFast.dto;

import ar.com.reduceFatFast.model.Ingrediente;
import lombok.Data;

/**
 * @author Matias
 *
 */
public @Data class IngredienteDto {
	public long id;
	public String name ;
	public Integer cantidad;
	public String unidad;
	
	public IngredienteDto(Ingrediente ingrediente) {
		super();
		this.setId(ingrediente.getId());
		this.setName(ingrediente.getName());
		this.setCantidad(ingrediente.getCantidad());
		this.setUnidad(ingrediente.getUnidad());
	}
}
