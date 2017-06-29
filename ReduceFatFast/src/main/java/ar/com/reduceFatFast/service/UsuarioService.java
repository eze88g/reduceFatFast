/**
 * 
 */
package ar.com.reduceFatFast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.repository.NutricionistaRepository;
import ar.com.reduceFatFast.repository.PacienteRepository;
import ar.com.reduceFatFast.repository.SistemaRepository;

/**
 * @author Matias
 *
 */
@Service
@Configuration
@Transactional
public class UsuarioService {
	
	@Autowired
	private SistemaRepository repository;
	
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	private SistemaRepository getRepository() {
		return repository;
	}

	private void setRepository(SistemaRepository repository) {
		this.repository = repository;
	}

	private PacienteRepository getPacienteRepository() {
		return pacienteRepository;
	}

	private void setPacienteRepository(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}
	
	private NutricionistaRepository getNutricionistaRepository() {
		return nutricionistaRepository;
	}

	private void setNutricionistaRepository(NutricionistaRepository nutricionistaRepository) {
		this.nutricionistaRepository = nutricionistaRepository;
	}

	private Sistema getSistema(){
		return getRepository().findOne(1l);
	}
	
	public Nutricionista crearNutricionista(String nombre, int dni) {
		Nutricionista nutricionista = new Nutricionista(nombre, dni);
		
		Sistema sistema = getSistema();
		if (sistema.agregarUsuario(nutricionista)) {
			return nutricionista;
		};
		
		return null;
	}

	public Paciente crearPaciente(String nombre, int dni) {
		Paciente paciente = new Paciente(nombre, dni);
		
		Sistema sistema = getSistema();
		if (sistema.agregarUsuario(paciente)) {
			return paciente;
		};
		
		return null;
	}

	public Iterable<Paciente> listarPacientes() {
		return getPacienteRepository().findAll();
	}

	public Iterable<Nutricionista> listarNutricionistas() {
		return getNutricionistaRepository().findAll();
	}	
	
}
