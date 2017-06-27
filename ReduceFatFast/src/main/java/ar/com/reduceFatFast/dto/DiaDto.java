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
	public int numero;
	public Integer cantidadComidasPorDia;
	public List<ComidaDto> comidas;
	
	public DiaDto(Dia dia, int numero) {
		super();
		this.setId(dia.getId());
		this.setNumero(numero);
		this.setCantidadComidasPorDia(dia.getCantidadComidasPorDia());
		this.setComidas(new ArrayList<ComidaDto>());
		
		for(Integer each : dia.getComidas().keySet()) {
			this.getComidas().add(new ComidaDto(dia.getComidas().get(each)));
		}
	}
}
