package ar.com.reduceFatFast.modelTest;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.GestorDeUsuario;
import ar.com.reduceFatFast.model.Ingrediente;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;

public class AgregarComidaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------- Inicio Crear Grupo Test-------");
		
		GestorDeUsuario gestor = new GestorDeUsuario();
		Paciente paciente1 = new Paciente("Jose",2222);
		Nutricionista unNutricionista = new Nutricionista("Chapatin",33546119,gestor);
		unNutricionista.crearGrupo();
		unNutricionista.agregarUnPacienteAlGrupo(paciente1);
		Ingrediente ingrediente1 = paciente1.crearIngrediente("Harina", 100);
		Ingrediente ingrediente2 = paciente1.crearIngrediente("Leche", 50);
		Comida comida1 = paciente1.crearComida("Torta");
		paciente1.agregarIngrediente(ingrediente1, 100, "gr", comida1);
		paciente1.agregarIngrediente(ingrediente2, 250, "cc", comida1);
		paciente1.agregarComida(comida1, 1, Comida.ComidaDelDia.ALMUERZO);
		
		
		
		System.out.println("------- Fin -------");
	}
}
