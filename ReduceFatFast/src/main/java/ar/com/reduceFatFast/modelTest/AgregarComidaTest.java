package ar.com.reduceFatFast.modelTest;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import ar.com.reduceFatFast.model.GestorDeUsuario;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Ingrediente;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;

public class AgregarComidaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------- Inicio Agregar Comida Test-------");
		
		GestorDeUsuario gestor = new GestorDeUsuario();
		Paciente paciente1 = new Paciente("Jose",2222);
		Paciente paciente2 = new Paciente("Juan",1234);
		
		//--- Creo nutricionista---
		// El nutricionista utiliza el gestor para poder crear un grupo
		Nutricionista unNutricionista = new Nutricionista("Chapatin",33546119,gestor);
		
		//---Creacion de grupo y carga de pacientes
		unNutricionista.crearGrupo();
		unNutricionista.agregarUnPacienteAlGrupo(paciente1);
		unNutricionista.agregarUnPacienteAlGrupo(paciente2);
		
		//Creacion de ingredientes y comida
		//TODO: habr� un registro de las comidas creadas o se guardan solamente en la comida del dia?
		Ingrediente ingrediente1 = paciente1.crearIngrediente("Harina", 100, "cucharadas");
		Ingrediente ingrediente2 = paciente1.crearIngrediente("Leche", 50, "cm3");
		Comida comida1 = paciente1.crearComida("Torta");
		
		Ingrediente ingrediente3 = paciente2.crearIngrediente("Azucar", 50, "cucharadas tamaño cafe");
		Ingrediente ingrediente4 = paciente2.crearIngrediente("Colores", 500, "medida de colores?");
		Comida comida2 = paciente1.crearComida("ChicaSP");
		
		
		//Se agregan los ingredientes a la comida y la comida a una comida del dia
		paciente1.agregarIngrediente("ingrediente1", 100, "gr", comida1);
		paciente1.agregarIngrediente("ingrediente2", 250, "cc", comida1);
		paciente1.agregarComida(comida1, 1, Comida.ComidaDelDia.ALMUERZO);
		
		paciente2.agregarIngrediente("ingrediente3", 1, "cucharada", comida2);
		paciente2.agregarIngrediente("ingrediente4", 300, "gr", comida2);
		paciente2.agregarComida(comida2, 1, ComidaDelDia.DESAYUNO);
		
		//--- Impresion de valores ---
		System.out.println("  ------- Valores Cargados: -------");
		Grupo unGrupo = paciente1.getGrupo();		
		for (int i = 0 ; i<7 ; i++ )
		{
			System.out.println("Dia "+(i+1));
			for (int j = 0 ; j<4;j++)
			{
				//unGrupo.getDietaSemanal().getDia(i).getComida(j).getNombre();
				System.out.println("  Comida:"+(j+1)+" "+unGrupo.getDietaSemanal().getDia(i).getComida(j).getNombre());
				unGrupo.getDietaSemanal().getDia(j).getComida(j).getIngredientes().forEach(ingredienteL->System.out.println("    "+ingredienteL.getName()+" "+ingredienteL.getCantidad()+ingredienteL.getUnidad()));
			}
		}
		
		System.out.println("------- Fin -------");
	}
}
