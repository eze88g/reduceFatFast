/**
 * 
 */
package ar.com.reduceFatFast.dto;

import ar.com.reduceFatFast.model.Nutricionista;
import lombok.Data;

/**
 * @author Matias
 *
 */
public @Data class NutricionistaDto {
	public String nombre;
	public int dni;
	public long id;
	
	public NutricionistaDto(Nutricionista nutricionista) {
		super();
		this.setId(nutricionista.getId());
		this.setNombre(nutricionista.getNombre());
		this.setDni(nutricionista.getDni());
	}
}
