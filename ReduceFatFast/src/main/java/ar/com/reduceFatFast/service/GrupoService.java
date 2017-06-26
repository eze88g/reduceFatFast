/**
 * 
 */
package ar.com.reduceFatFast.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.dto.DietaSemanalDto;

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
	
}
