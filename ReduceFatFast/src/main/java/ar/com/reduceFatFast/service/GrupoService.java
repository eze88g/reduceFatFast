/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.reduceFatFast.exception.ParametrosInvalidos;
import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import ar.com.reduceFatFast.model.DietaSemanal;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.repository.ComidaRepository;
import ar.com.reduceFatFast.repository.GrupoRepository;
import ar.com.reduceFatFast.repository.NutricionistaRepository;
import ar.com.reduceFatFast.repository.PacienteRepository;

/**
 * @author Matias
 *
 */
@Service
@Configuration
@Transactional
public class GrupoService extends AbstractService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private ComidaRepository comidaRepository;
	
	private GrupoRepository getGrupoRepository() {
		return grupoRepository;
	}

	private void setGrupoRepository(GrupoRepository grupoRepository) {
		this.grupoRepository = grupoRepository;
	}

	private PacienteRepository getPacienteRepository() {
		return pacienteRepository;
	}

	private void setPacienteRepository(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}
	
	private ComidaRepository getComidaRepository() {
		return comidaRepository;
	}

	private void setComidaRepository(ComidaRepository comidaRepository) {
		this.comidaRepository = comidaRepository;
	}

	private Sistema getSistema(){
		return getRepository().findOne(1l);
	}

	public Grupo crearGrupo(long id, String nombre) {
		Nutricionista nutricionista = nutricionistaRepository.findOne(id);
		this.checkearObjeto(nutricionista, "Nutricionista", id);
		
		if (nutricionista == null) {
			return null;
		}
		
		Grupo grupo = new Grupo(nutricionista, nombre);
		
		Sistema sistema = getSistema();
		sistema.agregarGrupo(grupo);
		
		return grupo;
	}

	public boolean agregarMiembro(long idNutricionista, long idGrupo, long idPaciente) {
		
		Grupo grupo = this.getGrupoRepository().findOne(idGrupo);
		this.checkearObjeto(grupo, "Grupo", idGrupo);
		
		if (null != grupo) {
			Paciente paciente = this.getPacienteRepository().findOne(idPaciente);
			this.checkearObjeto(paciente, "Paciente", idPaciente);
			
			if (null != paciente) {
				grupo.agregarPaciente(paciente);
				return true;
			}
		}

		return false;
	}

	public DietaSemanal obtenerDieta(long idGrupo) {
		
		Grupo grupo = this.getGrupoRepository().findOne(idGrupo);
		this.checkearObjeto(grupo, "Grupo", idGrupo);
		
		if (null != grupo) {
			return grupo.getDietaSemanal();
		}
		
		return null;
	}

	public List<Paciente> listarMiembros(long idGrupo) {
		
		Grupo grupo = this.getGrupoRepository().findOne(idGrupo);
		this.checkearObjeto(grupo, "Grupo", idGrupo);
		
		if (null != grupo) {
			return grupo.getPacientes();
		}
		
		return null;
	}

	public Iterable<Grupo> listarGrupos() {
		return this.getGrupoRepository().findAll();
	}

	public boolean validarDieta(long idGrupo, long idNutricionista) {
		Grupo grupo = this.getGrupoRepository().findOne(idGrupo);
		this.checkearObjeto(grupo, "Grupo", idGrupo);
		
		Nutricionista nutricionista = nutricionistaRepository.findOne(idNutricionista);
		this.checkearObjeto(nutricionista, "Nutricionista", idNutricionista);
		
		if (null != nutricionista && null != grupo) {
			return grupo.validarDieta(nutricionista);
		}
		
		return false;
	}

	public void agregarComidaADieta(long idGrupo, long idComida, Integer dia, int idComidaDelDia) {
		if (dia < 1 || dia > 7) {
			throw new ParametrosInvalidos("El dia debe poseer un valor entre 1 y 4");
		}
		ComidaDelDia comidaDelDia = null;
		switch (idComidaDelDia) {
		case 1:
			comidaDelDia = ComidaDelDia.DESAYUNO;
			break;
		case 2:
			comidaDelDia = ComidaDelDia.ALMUERZO;
			break;
		case 3:
			comidaDelDia = ComidaDelDia.MERIENDA;
			break;
		case 4:
			comidaDelDia = ComidaDelDia.CENA;
			break;
		default:
			throw new ParametrosInvalidos("La comida del dia debe poseer un valor entre 1 y 4");
		}
		
		Grupo grupo = this.getGrupoRepository().findOne(idGrupo);
		this.checkearObjeto(grupo, "Grupo", idGrupo);
		
		Comida comida = this.getComidaRepository().findOne(idComida);
		this.checkearObjeto(comida, "Comida", idComida);
				
		grupo.agregarComida(comida, dia, comidaDelDia);
	}
	
}
