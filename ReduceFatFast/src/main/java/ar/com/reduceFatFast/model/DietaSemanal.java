package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;

public class DietaSemanal {
	public boolean validacion;
//	private List<Dia> dias ;
	private List<Dia> dias = new ArrayList<Dia>(); //TODO: Donde incluir la cantidad??


	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}
	
	public void agregarComida (Comida unaComida, Integer numeroDeDia, ComidaDelDia comidaDelDia){
<<<<<<< HEAD
		dias.get(numeroDeDia).setComida(comidaDelDia, unaComida);
=======
		//dias.get(numeroDeDia).setComida(comidaDelDia, unaComida);
>>>>>>> 7a395380006c97e5603c6fcbf251b8a6891f4ae4
	}
	
}
