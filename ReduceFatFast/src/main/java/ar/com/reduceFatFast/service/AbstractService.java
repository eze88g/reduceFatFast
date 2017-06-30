/**
 * 
 */
package ar.com.reduceFatFast.service;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.reduceFatFast.exception.ParametrosInvalidos;
import ar.com.reduceFatFast.repository.SistemaRepository;

/**
 * @author Matias
 *
 */
public class AbstractService {
	
	@Autowired
	private SistemaRepository repository;
	
	protected SistemaRepository getRepository() {
		return repository;
	}

	protected void setRepository(SistemaRepository repository) {
		this.repository = repository;
	}

	public void checkearObjeto(Object objeto, String entidad, long id) {
		if (objeto == null) {
			throw new ParametrosInvalidos("Entidad " + entidad + " con id:" + id + " no encontrada");
		}
	}
	
}
