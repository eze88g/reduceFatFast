/**
 * 
 */
package ar.com.reduceFatFast.testconpersistencia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ar.com.reduceFatFast.ReduceFatFastApplication;
import ar.com.reduceFatFast.ReduceFatFastApplicationTests;
import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.service.ComidaService;

/**
 * @author joaco
 *
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("mysql")
@SpringBootTest(classes = ReduceFatFastApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class ComidaServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ComidaServiceTest.class);
	
	private static final int THREADCOUNT = 10;
	
	@Autowired
	private ComidaService service;
	
	protected Comida comidaTest;
	private final int cantidadCalorias = 1000;
	private final String nombreComida = "Milanesa a Caballo";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		comidaTest = crearComida();
	}
	
	private Comida crearComida(){
		Comida c = new Comida(nombreComida);
		c.setId(1l);
		c.setCantidadCalorias(cantidadCalorias);
		c.agregarIngrediente("Milanesa", 250, "kg");
		c.agregarIngrediente("Huevo Frito", 2, "unidad");
		c.agregarIngrediente("Papas Fritas", 500, "gr");
		return c;
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#crearComida(int, java.lang.String, long)}.
	 */
	@Test
	public void testCrearComida() {
		try{
			// creo una comida y persisto
			this.service.crearComida(0, nombreComida, comidaTest.getCantidadCalorias());	
			Comida comidaGuardada = this.service.listarComidas().get(0);
			assertNotEquals(0, comidaGuardada.getId());
			this.assertsComida(comidaTest, comidaGuardada);
	
		}catch(Exception e){
			fail("No se espera que levante una exception");
		}	
	}
	
	private void assertsComida(Comida comidaEsperada, Comida comidaObtenida){
		assertEquals(comidaEsperada.getId(), comidaObtenida.getId());
		assertEquals(comidaEsperada.getNombre(), comidaObtenida.getNombre());
		assertEquals(comidaEsperada.getIngredientes().size(), comidaObtenida.getIngredientes().size());	
	}
	
	@Test
	public void testCrearComidaConcurrente() {
		List<Thread> threads = new ArrayList<>();
		try{
			for (int i = 0; i < THREADCOUNT; i++) {		
				Runnable task = () -> {
					try{
					    String threadName = Thread.currentThread().getName();
					    logger.info("Iniciando " + threadName);
					    Comida comida = this.service.crearComida(0, threadName, comidaTest.getCantidadCalorias());					    
					    //Optional<Comida> comidaObtenida = this.service.listarComidas().stream().findFirst().filter(x -> x.getId() == comida.getId());
						assertNotEquals(0, comida.getId());
						assertEquals(threadName, comida.getNombre());
						assertEquals(comidaTest.getCantidadCalorias(), comida.getCantidadCalorias());	
						logger.info("Finalizando " + threadName);
					}catch(Exception e){					
						e.printStackTrace();
						fail("ocurrio un error inesperado");
						throw e;
					}

				};
				
				Thread thread = new Thread(task);
				threads.add(thread);
				
			}

			for (Thread t : threads) {
				t.start();
			}	
		}catch(Exception e){
			fail("No se espera que levante una exception");
		}
		
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#editarComida(long, int, java.lang.String, long)}.
	 */
	@Test
	public void testEditarComida() {
		try{
			// creo una comida y persisto
			String nombreComidaSinEditar = new String ("Papas en Julianas");
			Comida comida = this.service.crearComida(0, nombreComidaSinEditar, 1000);
//			final long id = comida.getId();
//			Comida comidaGuardada = this.service.listarComidas().get(0);
//			comida = this.service.editarComida(comida.getId(), 0, comidaTest.getNombre(), comidaTest.getCantidadCalorias());
//			comidaGuardada = (Comida) this.service.listarComidas().stream().filter(x -> x.getId()==id);
//			assertsComida(comidaTest,comidaGuardada);		
		}catch(Exception e){
			fail("No se espera que levante una exception");
		}	
	}
	
	@Test
	public void testEditarComidaConcurrente() {
		// creo una comida y persisto
		logger.info("Creando Comida");
		String nombreComida = new String("Papas Fritas");
		String nombreComidaEditada = new String ("Papas en Julianas");
		Integer pesoInicial = 1000;
		Integer pesoEditado = 1500;
		this.service.crearComida(0, nombreComida, 1000);
		
		List<Thread> threads = new ArrayList<>();
		try{
			for (int i = 0; i < THREADCOUNT; i++) {		
				Runnable task = () -> {
					try{ 
					    String threadName = Thread.currentThread().getName();
					    String nombreEditado = nombreComidaEditada +  " " + threadName;
					    logger.info("Iniciando " + threadName);
					    logger.debug(threadName + " - Listando Comidas");
					    Comida comida = this.service.listarComidas().get(0);
					    logger.debug(threadName + " - Editando Comidas" );
					    this.service.editarComida(comida.getId(), 0,  nombreEditado, 2000);
					    logger.debug(threadName + " - Listando Comidas post modificación");
						Comida comidaObtenida = this.service.listarComidas().get(0);
						logger.debug(threadName + " - Asserts");
					    //Optional<Comida> comidaObtenida = this.service.listarComidas().stream().findFirst().filter(x -> x.getId() == 1);
					    assertEquals(comida.getId(), comidaObtenida.getId());
						assertTrue(comidaObtenida.getNombre().contains(nombreComidaEditada));
						assertEquals(2000, comidaObtenida.getCantidadCalorias());
						logger.info("Finalizando " + threadName);
					}catch(ObjectOptimisticLockingFailureException e){
						e.printStackTrace();
					}catch(Exception e){					
						e.printStackTrace();
						fail("ocurrio un error inesperado");
						throw e;
					}

				};
				
				Thread thread = new Thread(task);
				threads.add(thread);
				
			}

			for (Thread t : threads) {
				t.start();
			}	
		}catch(Exception e){
			fail("No se espera que levante una exception");
		}	
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#agregarIngrediente(int, long, java.lang.String, int, java.lang.String)}.
	 */
//	@Test
//	public void testAgregarIngrediente() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#listarComidas()}.
	 */
	@Test
	public void testListarComidas() {
		List<Thread> threads = new ArrayList<>();
		List<String> comidas = new ArrayList<String>();
		comidas.add("Pure de Zapallo");
		comidas.add("Milanesas");
		comidas.add("Ensalada de Remolacha");
		comidas.add("Pizza");
		for (String string : comidas) {
			this.service.crearComida(1, string, 1000);		
		}
		
		try{
			for (int i = 0; i < THREADCOUNT; i++) {		
				Runnable task = () -> {
					try{
					    String threadName = Thread.currentThread().getName();
					    logger.info("Iniciando " + threadName);
					    List<Comida> comidaObtenida = this.service.listarComidas();
					    int j = 0;
					    for (String string : comidas) {
							assertEquals(string, comidaObtenida.get(j++).getNombre());;
						}
					    logger.info("Finalizando " + threadName);
					}catch(Exception e){					
						//e.printStackTrace();
						fail("ocurrio un error inesperado");
						throw e;
					}

				};
				
				Thread thread = new Thread(task);
				threads.add(thread);
				
			}

			for (Thread t : threads) {
				t.start();
			}	
		}catch(Exception e){
			fail("No se espera que levante una exception");
		}
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#eliminarComida(long)}.
	 */
//	@Test
//	public void testEliminarComida() {
//		fail("Not yet implemented");
//	}

}
