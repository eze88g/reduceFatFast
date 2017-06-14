package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;

public class DietaSemanal {
	public boolean validacion;
//	private List<Dia> dias ;
	//public List<Dia> dias = new ArrayList<Dia>(); //TODO: Donde incluir la cantidad??
	public Dia dias[] ;

	public DietaSemanal() {
		dias = new Dia[7] ;
		for (int i=0;i<7;i++)
		{
			dias[i]=new Dia();
		}
		
	}
	
	
	public Dia getDia(Integer n) {
		return dias[n];
	}


	public void setDias(Dia[] dias) {
		this.dias = dias;
	}



	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}
	
	public void agregarComida (Comida unaComida, Integer numeroDeDia, ComidaDelDia comidaDelDia){
		dias[numeroDeDia].setComida(comidaDelDia, unaComida);
	}
	
}
