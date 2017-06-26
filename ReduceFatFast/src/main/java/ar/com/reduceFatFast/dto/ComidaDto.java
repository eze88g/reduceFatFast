/**
 * 
 */
package ar.com.reduceFatFast.dto;

import java.util.ArrayList;
import java.util.List;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Ingrediente;
import lombok.Data;

/**
 * @author Matias
 *
 */
public @Data class ComidaDto {
	public long id;
	public int version;
	public String nombre;
	public long cantidadCalorias;
	public List<IngredienteDto> ingredientes;
	
	public ComidaDto(Comida comida) {
		super();
		this.setId(comida.getId());
		this.setVersion(comida.getVersion());
		this.setNombre(comida.getNombre());
		this.setCantidadCalorias(comida.getCantidadCalorias());
		this.setIngredientes(new ArrayList<IngredienteDto>());
		
		for(Ingrediente each : comida.getIngredientes()) {
			this.getIngredientes().add(new IngredienteDto(each));
		}
	}
}
