/**
 * 
 */
package ar.com.reduceFatFast.dto;

import java.util.ArrayList;
import java.util.List;

import ar.com.reduceFatFast.model.DietaSemanal;
import lombok.Data;

/**
 * @author Matias
 *
 */
public @Data class DietaSemanalDto {
	public long id;
	public boolean validacion;
	public List<DiaDto> dias;
	
	public DietaSemanalDto(DietaSemanal dieta) {
		super();
		this.setId(dieta.getId());
		this.setValidacion(dieta.isValidacion());
		this.setDias(new ArrayList<DiaDto>());
		
		for (Long each: dieta.getDias().keySet()) {
			this.getDias().add(new DiaDto(dieta.getDia(each), each));
		}
	}
}
