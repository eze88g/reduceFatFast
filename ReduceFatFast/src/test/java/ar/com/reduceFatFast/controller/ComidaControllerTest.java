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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
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
@AutoConfigureMockMvc
public class ComidaControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(), MediaType.APPLICATION_JSON_UTF8.getSubtype(), Charset.forName("utf8"));
	@Autowired
	private MockMvc mockMvc;
//	private HttpMessageConverter mappingJackson2HttpMessageConverter;
//	@Autowired
//	private SistemaRepository sistemaRepository;
//	@Autowired
//	private ComidaRepository comidaRepository;
//	@Autowired
//	private WebApplicationContext webApplicationContext;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
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

}
