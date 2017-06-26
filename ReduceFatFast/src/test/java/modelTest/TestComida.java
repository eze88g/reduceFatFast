package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Sistema;

public class TestComida {
	
	Sistema sistema;
	Paciente paciente;
	
	@Before
	public void setUp() throws Exception {
		sistema = new Sistema ();
		paciente = new Paciente("Juan",330000,sistema);
	}

	@Test
	public void testAgregarComida() {
		Comida unaComida;
		unaComida = paciente.crearComida("Pizza");
		unaComida.agregarIngrediente("Sal", 100, "gr");
		assertEquals(1, sistema.getComidas().size());
		assertEquals(1, sistema.getComidas().get(0).getIngredientes().size());
	}
}
