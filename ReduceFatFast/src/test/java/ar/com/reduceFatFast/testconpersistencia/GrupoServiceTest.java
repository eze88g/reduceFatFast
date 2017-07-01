/**
 * 
 */
package ar.com.reduceFatFast.testconpersistencia;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ar.com.reduceFatFast.ReduceFatFastApplication;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.repository.NutricionistaRepository;
import ar.com.reduceFatFast.repository.SistemaRepository;
import ar.com.reduceFatFast.service.GrupoService;

/**
 * @author joaco
 *
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("h2")
@SpringBootTest(classes = ReduceFatFastApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class GrupoServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(GrupoServiceTest.class);
	
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	@Autowired
	private GrupoService service;
	
	Nutricionista nutricionista = null;
	
	@Before
	public void setUp() {
		nutricionista = this.nutricionistaRepository.save(new Nutricionista("unNutricionista", 12345678));
	}
	
	@Test
	public void testCrearGrupo() {
		String nombre = "unNombre";
		
		Grupo grupo = this.service.crearGrupo(nutricionista.getId(), nombre);	
		
		assertNotEquals(0, grupo.getId());
		assertTrue(nombre.equals(grupo.getNombre()));
	}

}
