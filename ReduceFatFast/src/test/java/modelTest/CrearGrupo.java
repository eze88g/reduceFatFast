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

public class CrearGrupo {
	
	Nutricionista unNutricionista;
	Grupo unGrupo;
	Paciente paciente1;
	Paciente paciente2;
	Comida unaComida;
	
	@Before
	public void setUp() throws Exception {
		Sistema sistema = new Sistema();
		unNutricionista = new Nutricionista("Chapatin",33546119,sistema);
		paciente1 = new Paciente("Ariel", 33546119,sistema);
		paciente2 = new Paciente("Susana", 21546119,sistema);

	}
	
	@Test
	public void testCrearGrupo() {
		unGrupo = unNutricionista.crearGrupo("Adultos");
		assertEquals("Adultos", unNutricionista.getGrupos().get(0).getNombre());
		assertEquals(1, unNutricionista.getGrupos().size());
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
		assertEquals(7, unGrupo.getDietaSemanal().getDias().size());
		assertEquals(4, unGrupo.getDietaSemanal().getDias().get(1).getComidas().size());
		assertEquals("Pizza", unGrupo.getDietaSemanal().dias.get(1).getComida(ComidaDelDia.ALMUERZO).getNombre());
	}
	
	//TODO:
	public void testCrearGrupoIgualNombre() {
		
	}
}
