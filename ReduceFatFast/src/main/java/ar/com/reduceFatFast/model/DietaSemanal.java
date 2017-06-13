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
		//dias.get(numeroDeDia).setComida(comidaDelDia, unaComida);
	}
	
}
