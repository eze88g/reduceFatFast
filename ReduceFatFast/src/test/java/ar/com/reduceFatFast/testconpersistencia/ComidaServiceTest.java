/**
 * 
 */
package ar.com.reduceFatFast.testconpersistencia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
@ActiveProfiles("h2")
@SpringBootTest(classes = ReduceFatFastApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class ComidaServiceTest {
	
	@Autowired
	private ComidaService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#crearComida(int, java.lang.String, long)}.
	 */
	@Test
	public void testCrearComida() {
		try{
			// creo una comida y persisto
			String nombreComida = new String("Papas Fritas");
			Comida comida = this.service.crearComida(0, nombreComida, 1000);
			assertNotEquals(0, comida.getId());
			Comida comidaGuardada = this.service.listarComidas().get(0);
			this.assertsComida(comida, comidaGuardada);
	
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
			for (int i = 0; i < 5; i++) {		
				Runnable task = () -> {
					try{
					    String threadName = Thread.currentThread().getName();
					    System.out.println("Iniciando " + threadName);
					    Comida comida = this.service.crearComida(0, threadName, 1000);
					    System.out.println("Iniciando " + threadName);
					    Optional<Comida> comidaObtenida = this.service.listarComidas().stream().findFirst().filter(x -> x.getId() == comida.getId());
					    this.assertsComida(comida, comidaObtenida.get());						
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
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#editarComida(long, int, java.lang.String, long)}.
	 */
	@Test
	public void testEditarComida() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#agregarIngrediente(int, long, java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testAgregarIngrediente() {
		fail("Not yet implemented");
	}

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
			for (int i = 0; i < 5; i++) {		
				Runnable task = () -> {
					try{
					    String threadName = Thread.currentThread().getName();
					    System.out.println("Iniciando " + threadName);
					    List<Comida> comidaObtenida = this.service.listarComidas();
					    System.out.println("Finalizando " + threadName);
					    int j = 0;
					    for (String string : comidas) {
							assertEquals(string, comidaObtenida.get(j++).getNombre());;
						}						
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
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#listarIngredientes(long)}.
	 */
	@Test
	public void testListarIngredientes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#eliminarComida(long)}.
	 */
	@Test
	public void testEliminarComida() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#obtenerIngrediente(long, long)}.
	 */
	@Test
	public void testObtenerIngrediente() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#eliminarIngrediente(long, long)}.
	 */
	@Test
	public void testEliminarIngrediente() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.service.ComidaService#actualizarIngrediente(long, long, java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testActualizarIngrediente() {
		fail("Not yet implemented");
	}

}
