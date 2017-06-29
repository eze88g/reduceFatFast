package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import ar.com.reduceFatFast.model.Dia;
import ar.com.reduceFatFast.model.DietaSemanal;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Sistema;

public class TestComida {
	
	Sistema sistema;
	Paciente paciente;
	
	@Before
	public void setUp() throws Exception {
		sistema = new Sistema ();
		paciente = new Paciente("Juan",330000);
	}

	@Test
	public void testAgregarComida() {
		Comida unaComida;
		unaComida = paciente.crearComida("Pizza");
		unaComida.agregarIngrediente("Sal", 100, "gr");
		sistema.agregarComida(unaComida);
		assertEquals(1, sistema.getComidas().size());
		assertEquals(1, sistema.getComidas().get(0).getIngredientes().size());
	}
	
	@Test
	public void testAgregarComidaDieta() {
		Comida unaComida;
		DietaSemanal dieta = new DietaSemanal();
		unaComida = paciente.crearComida("Pizza");
		unaComida.agregarIngrediente("Sal", 100, "gr");
		dieta.agregarComida(unaComida, 1, ComidaDelDia.ALMUERZO);
		assertEquals ("Pizza",dieta.getDia(1).getComida(ComidaDelDia.ALMUERZO).getNombre());
	}
	
	@Test
	public void testAgregarComidaDia() {
		Comida unaComida;
		Dia dia = new Dia();
		unaComida = paciente.crearComida("Pizza");
		unaComida.agregarIngrediente("Sal", 100, "gr");
		dia.setComida(ComidaDelDia.ALMUERZO, unaComida);
		assertEquals(1, dia.getComidas().size());
		//assertEquals(1, sistema.getComidas().get(0).getIngredientes().size());
	}
}
