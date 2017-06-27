/**
 * 
 */
package ar.com.reduceFatFast.dto;

import ar.com.reduceFatFast.model.Paciente;
import lombok.Data;

/**
 * @author Matias
 *
 */
public @Data class PacienteDto {
	public String nombre;
	public int dni;
	public long id;
	
	public PacienteDto(Paciente paciente) {
		super();
		this.setId(paciente.getId());
		this.setNombre(paciente.getNombre());
		this.setDni(paciente.getDni());
	}
}
