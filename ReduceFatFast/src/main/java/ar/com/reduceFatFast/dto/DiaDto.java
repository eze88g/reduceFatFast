/**
 * 
 */
package ar.com.reduceFatFast.dto;

import java.util.ArrayList;
import java.util.List;

import ar.com.reduceFatFast.model.Dia;
import lombok.Data;

/**
 * @author Matias
 *
 */
public @Data class DiaDto {
	public long id;
	public Long numero;
	public Integer cantidadComidasPorDia;
	public List<ComidaDto> comidas;
	
	public DiaDto(Dia dia, Long numero) {
		super();
		this.setId(dia.getId());
		this.setNumero(numero);
		this.setCantidadComidasPorDia(dia.getCantidadComidasPorDia());
		this.setComidas(new ArrayList<ComidaDto>());
		
		for(Long each : dia.getComidas().keySet()) {
			this.getComidas().add(new ComidaDto(dia.getComidas().get(each)));
		}
	}
}
