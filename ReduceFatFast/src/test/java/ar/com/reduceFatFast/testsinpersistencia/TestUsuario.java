package ar.com.reduceFatFast.testsinpersistencia;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Sistema;

public class TestUsuario {

	Sistema sistema;
	Paciente unPaciente;
	Nutricionista unNutricionista;
	@Before
	public void setUp() throws Exception {
		sistema = new Sistema ();
		unPaciente = new Paciente("Jose", 1234);
		unNutricionista = new Nutricionista ("Marta", 5461);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAgregarUsuario() {
		sistema.agregarUsuario(unPaciente);
		sistema.agregarUsuario(unNutricionista);
		assertEquals(2, sistema.getUsuarios().size());
	}
	
	@Test
	public void testBuscarUsuario() {
		sistema.agregarUsuario(unPaciente);
		assertEquals (unPaciente, sistema.buscarUsuarioByDni(unPaciente.getDni()));
	}

	@Test
	public void testAgregarDniRepetido() {
		Paciente otroPaciente = new Paciente("Marcos", 1234);
		sistema.agregarUsuario(unPaciente);
		assertEquals (false, sistema.agregarUsuario(otroPaciente));
		assertEquals (1, sistema.getUsuarios().size());
	}
}
