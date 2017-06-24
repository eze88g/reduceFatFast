/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import ar.com.reduceFatFast.repository.ComidaRepository;
import ar.com.reduceFatFast.repository.DiaRepository;
import ar.com.reduceFatFast.repository.IngredienteRepository;

/**
 * @author joaco
 *
 */
public class GeneralRepository {
	
//	@Autowired
//	private IngredienteRepository ingredienteRepository;
//	
//	@Autowired
//	private ComidaRepository comidaRepository;
//	
//	@Autowired
//	private DiaRepository diaRepository;
	
	private HashMap<String, CrudRepository> map;
	
	void add(Object object) throws Exception{
		CrudRepository repository = map.get(object.getClass().getSimpleName());
		repository.save(object);
	}

}
