package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.model.Comida.ComidaDelDia;

public class TestGrupo {
	
	Nutricionista unNutricionista;
	Grupo unGrupo;
	Paciente paciente1;
	Paciente paciente2;
	Comida unaComida;
	Sistema sistema;
	@Before
	public void setUp() throws Exception {
		sistema = new Sistema();
		unNutricionista = new Nutricionista("Chapatin",33546119,sistema);
		paciente1 = new Paciente("Ariel", 33546119,sistema);
		paciente2 = new Paciente("Susana", 21546119,sistema);

	}
	
	@Test
	public void testBorrarGrupoAjeno() {
		Nutricionista otroNutricionista = new Nutricionista("Jose",33546229,sistema);
		Grupo otroGrupo = otroNutricionista.crearGrupo("otroGrupo");
		assertEquals(false,unNutricionista.borrarGrupo(otroGrupo));
		assertEquals(1, otroNutricionista.getGrupos().size());
		assertEquals(1, sistema.getGrupos().size());
	}
	
	@Test
	public void testBorrarGrupo() {
		unGrupo = unNutricionista.crearGrupo("Adultos");
		assertEquals(1, unNutricionista.getGrupos().size());
		unNutricionista.borrarGrupo(unGrupo);
		assertEquals(0, unNutricionista.getGrupos().size());
		assertEquals(0, sistema.getGrupos().size());
	}
	
	@Test
	public void testCrearGrupoRepetido() {
		unGrupo = unNutricionista.crearGrupo("Adultos");
		Grupo grupoRepetido = unNutricionista.crearGrupo("Adultos");
		assertEquals(null, grupoRepetido);
		assertEquals(1, unNutricionista.getGrupos().size());
	}

	@Test
	public void testBuscarGrupo() {	
		unGrupo = unNutricionista.crearGrupo("Adultos");
		assertEquals(unGrupo, unNutricionista.buscarGrupo("Adultos"));
		assertEquals(null, unNutricionista.buscarGrupo("falso"));
	}
	
	@Test
	public void testCrearGrupo() {
		unGrupo = unNutricionista.crearGrupo("Adultos");
		assertEquals("Adultos", unNutricionista.getGrupos().get(0).getNombre());
		assertEquals(1, unNutricionista.getGrupos().size());
		assertEquals(1, sistema.getGrupos().size());
	}
	
	@Test
	public void testAgregarPaciente() {
		unNutricionista.crearGrupo("Adultos");
		unGrupo = unNutricionista.getGrupos().get(0);
		unGrupo.agregarPaciente(paciente1);
		unGrupo.agregarPaciente(paciente2);
		assertEquals(2, unGrupo.getPacientes().size());
	}
	
	@Test
	public void testAgregarComida() {
		unaComida = new Comida ("Pizza");
		this.testCrearGrupo();
		this.testAgregarPaciente();
		paciente1.agregarComida(unaComida, 1, ComidaDelDia.ALMUERZO);
		assertEquals(1, unGrupo.getDietaSemanal().getDias().size());
		assertEquals(1, unGrupo.getDietaSemanal().getDia(1).getComidas().size());
	}
}
