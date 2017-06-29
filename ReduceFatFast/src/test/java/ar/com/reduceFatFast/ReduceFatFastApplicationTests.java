package ar.com.reduceFatFast;

import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.repository.SistemaRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("h2")
@SpringBootTest
public class ReduceFatFastApplicationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(ReduceFatFastApplicationTests.class);
	
	@Autowired
	SistemaRepository repository;

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void crearSistemaTest(){
		try{
			logger.info("Creo un sistema nuevo y lo guardo");
			List<Sistema> sistemaList= (List<Sistema>) repository.findAll();
			Assert.assertEquals(1,sistemaList.size());
			
			Sistema sistema = sistemaList.get(0);
			Hibernate.initialize(sistema);
			Hibernate.initialize(sistema.getComidas());
			
			logger.info("Agrego una comida y guardo");
			Comida comida = new Comida("Cafe");
			sistema.getComidas().add(comida);
			repository.save(sistema);
			
			logger.info("Agrego un usuario y guardo");
			Paciente paciente = new Paciente("Lebron", 30156142);
			Nutricionista nutricionista = new Nutricionista("Samanta", 30156181);
			sistema.getUsuarios().add(paciente);
			sistema.getUsuarios().add(nutricionista);
			repository.save(sistema);
			Assert.assertEquals(sistema.getUsuarios().size(), repository.findOne(sistema.getId()).getUsuarios().size());

			logger.info("Agrego un grupo y guardo");
			Grupo grupo = new Grupo(nutricionista,"Gorditos");
			sistema.getGrupos().add(grupo);
			repository.save(sistema);
			Assert.assertEquals(sistema.getGrupos().size(), repository.findOne(sistema.getId()).getGrupos().size());
			
			Assert.assertNull(((List<Sistema>)repository.findAll()).size()==1);
			
		}catch(Exception e){
			Assert.fail();
		}
		
		
	}

	
	// Setters and Getters
	
	/**
	 * @return the repository
	 */
	public SistemaRepository getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(SistemaRepository repository) {
		this.repository = repository;
	}
	
	

}
