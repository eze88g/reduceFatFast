/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.HashMap;

import org.springframework.data.repository.CrudRepository;

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
