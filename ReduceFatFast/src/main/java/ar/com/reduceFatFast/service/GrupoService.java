/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.dto.DietaSemanalDto;
import ar.com.reduceFatFast.dto.GrupoDto;
import ar.com.reduceFatFast.dto.PacienteDto;

/**
 * @author Matias
 *
 */
@Service
@Configuration
public class GrupoService {
	
	public boolean crearGrupo(long id, String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean agregarMiembro(long idNutricionista, long idGrupo, long idPaciente) {
		// TODO Auto-generated method stub
		return false;
	}

	public DietaSemanalDto obtenerDieta(long idGrupo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PacienteDto> listarMiembros(long idUsuario, long idGrupo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GrupoDto> listarGrupos() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validarDieta(long idUsuario, long idGrupo) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
