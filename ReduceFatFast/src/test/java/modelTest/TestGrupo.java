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
		unNutricionista = new Nutricionista("Chapatin",33546119);
		paciente1 = new Paciente("Ariel", 33546119);
		paciente2 = new Paciente("Susana", 21546119);

	}
	
/*	@Test
	public void testBorrarGrupoAjeno() {
		Nutricionista otroNutricionista = new Nutricionista("Jose",33546229);
		
		Grupo otroGrupo = new Grupo(otroNutricionista,"otro Grupo");
		sistema.agregarGrupo(otroGrupo);;
		assertEquals(false,unNutricionista.borrarGrupo(otroGrupo));
		assertEquals(1, otroNutricionista.getGrupos().size());
		assertEquals(1, sistema.getGrupos().size());
	}
	*/
	@Test
	public void testBorrarGrupo() {
		unGrupo = new Grupo(unNutricionista,"Gorditos");
		sistema.agregarGrupo(unGrupo);
		assertEquals(1, sistema.getGrupos().size());
		assertEquals(true,sistema.borrarGrupo(unGrupo));
		assertEquals(0, unNutricionista.getGrupos().size());
		assertEquals(0, sistema.getGrupos().size());
	}

	@Test
	public void testCrearGrupo() {
		unGrupo =  new Grupo(unNutricionista,"Gorditos");
		sistema.agregarGrupo(unGrupo);
		//assertEquals(1, unNutricionista.getGrupos().size());
		assertEquals(1, sistema.getGrupos().size());
	}
	
	@Test
	public void testCrearGrupoRepetido() {
		unGrupo =  new Grupo(unNutricionista,"Gorditos");
		sistema.agregarGrupo(unGrupo);
		Grupo otroGrupo =  new Grupo(unNutricionista,"Gorditos");
		assertEquals(false, sistema.agregarGrupo(otroGrupo));
		assertEquals(1, unNutricionista.getGrupos().size());
	}

	@Test
	public void testBuscarGrupo() {	
		unGrupo =  new Grupo(unNutricionista,"Gorditos");
		sistema.agregarGrupo(unGrupo);
		assertEquals(unGrupo, unNutricionista.buscarGrupo("Gorditos"));
		assertEquals(null, unNutricionista.buscarGrupo("falso"));
	}

	
	@Test
	public void testAgregarPaciente() {
		unGrupo = new Grupo(unNutricionista,"Gorditos");
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
