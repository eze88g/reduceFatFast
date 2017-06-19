/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.repository.SistemaRepository;

/**
 * @author joaco
 *
 */
@Service
@Transactional
public class SistemaService {

	@Autowired
	SistemaRepository sistemaRepository;
	
	public void save(Sistema sistema){
		this.getSistemaRepository().save(sistema);
	}
	
	/**
	 * @return the sistemaRepository
	 */
	public SistemaRepository getSistemaRepository() {
		return sistemaRepository;
	}

	/**
	 * @param sistemaRepository the sistemaRepository to set
	 */
	public void setSistemaRepository(SistemaRepository sistemaRepository) {
		this.sistemaRepository = sistemaRepository;
	}

	public List<Sistema> findAll() {		
		return (List<Sistema>) this.getSistemaRepository().findAll();
	}
	
}
