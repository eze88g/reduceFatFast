/**
 * 
 */
package ar.com.reduceFatFast.dto;

import java.util.List;

import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Paciente;
import lombok.Data;

/**
 * @author Matias
 *
 */
public @Data class GrupoDto {
	public long id;
	public long version;
	public String nombre;
	public NutricionistaDto nutricionista;
	public List<PacienteDto> pacientes;
	public DietaSemanalDto dietaSemanal;
	
	public GrupoDto(Grupo grupo) {
		super();
		this.setId(grupo.getId());
		this.setVersion(grupo.getVersion());
		this.setNombre(grupo.getNombre());
		this.setNutricionista(new NutricionistaDto(grupo.getNutricionista()));
		this.setDietaSemanal(new DietaSemanalDto(grupo.getDietaSemanal()));
		for(Paciente each : grupo.getPacientes()) {
			this.getPacientes().add(new PacienteDto(each));
		}
	}
}
