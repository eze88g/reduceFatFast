/**
 * 
 */
package ar.com.reduceFatFast.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ar.com.reduceFatFast.ReduceFatFastApplication;
import ar.com.reduceFatFast.repository.ComidaRepository;
import ar.com.reduceFatFast.repository.SistemaRepository;

/**
 * @author joaco
 *
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("h2")
@SpringBootTest(classes = ReduceFatFastApplication.class)
@WebAppConfiguration
public class ComidaControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_FORM_URLENCODED.getType(), MediaType.APPLICATION_FORM_URLENCODED.getSubtype(), Charset.forName("utf8"));
	private MockMvc mockMvc;
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	@Autowired
	private SistemaRepository sistemaRepository;
	@Autowired
	private ComidaRepository comidaRepository;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@InjectMocks
	ComidaController controller;

	
	void setConverters(HttpMessageConverter<?>[] converters){
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);
		
		assertNotNull("The Json message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#getComidaService()}.
	 */
	@Test
	public void testGetComidaService() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#setComidaService(ar.com.reduceFatFast.service.ComidaService)}.
	 */
	@Test
	public void testSetComidaService() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#crearComida(int, java.lang.String, long)}.
	 */
	@Test
	public void testCrearComida() {
		try{
			mockMvc.perform(MockMvcRequestBuilders.post("/comidas").param("1", "Papas Fritas", "233").contentType(MediaType.APPLICATION_FORM_URLENCODED))
	        .andExpect(status().isOk());
		}catch(Exception e){
			fail("Ocurrio un error tratando de crear una comida");
		}
		
		
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#listarComidas()}.
	 */
	@Test
	public void testListarComidas() {
		try{
			mockMvc.perform(MockMvcRequestBuilders.get("/comidas")).andExpect(status().isOk());
		}catch(Exception e){
			fail("Ocurrio un error tratando de listar las comidas");
		}	
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#editarComida(java.lang.Long, java.lang.Integer, java.lang.String, java.lang.Long)}.
	 */
	@Test
	public void testEditarComida() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#eliminarComida(long)}.
	 */
	@Test
	public void testEliminarComida() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#agregarIngrediente(long, int, java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testAgregarIngrediente() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#listarIngredientes(long)}.
	 */
	@Test
	public void testListarIngredientesLong() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#listarIngredientes(long, long)}.
	 */
	@Test
	public void testListarIngredientesLongLong() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#eliminarIngrediente(long, long)}.
	 */
	@Test
	public void testEliminarIngrediente() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.ComidaController#actualizarIngrediente(long, long, java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testActualizarIngrediente() {
		fail("Not yet implemented");
	}

}
