/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.dto.NutricionistaDto;
import ar.com.reduceFatFast.dto.PacienteDto;

/**
 * @author Matias
 *
 */
@Service
@Configuration
public class UsuarioService {
	
	public boolean crearNutricionista(String nombre, int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean crearPaciente(String nombre, int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<PacienteDto> listarPacientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<NutricionistaDto> listarNutricionistas() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
