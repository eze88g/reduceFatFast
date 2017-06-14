package ar.com.reduceFatFast.modelTest;

import ar.com.reduceFatFast.model.GestorDeUsuario;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;

public class CrearGrupoTest {

	GestorDeUsuario gestor = new GestorDeUsuario();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("------- Inicio -------");

		CrearGrupoTest test =  new CrearGrupoTest();
		test.agregarPacientesTest();
		System.out.println("------- Fin -------");
	}

	public void agregarPacientesTest(){

		
		Paciente paciente1 = new Paciente("Ramon",1111);
		Paciente paciente2 = new Paciente("Jose",2222);
		
		Nutricionista unNutricionista = new Nutricionista("Chapatin",33546119,gestor);
		unNutricionista.crearGrupo();
		unNutricionista.agregarUnPacienteAlGrupo(paciente1);
		unNutricionista.agregarUnPacienteAlGrupo(paciente2);
		
		System.out.println("Pacientes del grupo:");
		unNutricionista.getGrupo().getPacientes().forEach(pacienteL->System.out.println(pacienteL.getNombre()));
	}
}
