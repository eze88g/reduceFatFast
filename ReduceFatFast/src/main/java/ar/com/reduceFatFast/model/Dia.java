package ar.com.reduceFatFast.model;


import java.util.List;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;

public class Dia {

	//private List<Comida> comidas;
	private Comida comidas [];
	
	public Dia() {
		//this.comidas = new ArrayList<Comida>();
		this.comidas = new Comida[4];
		for (int i=0;i<4;i++)
		{
			comidas[i]=new Comida("null");
		}
	}

	public Comida getComida(Integer n) {
		return comidas[n];
	}
	
	public Comida[] getComidas() {
		return comidas;
	}


	public void setComidas(Comida[] comidas) {
		this.comidas = comidas;
	}


	public void setComida(ComidaDelDia comidaDelDia, Comida unaComida) {
		int n ;
		switch(comidaDelDia) {
		case DESAYUNO :
			n = 1;
			break; // optional
		case ALMUERZO :
			n = 2;
			break; // optional
		case MERIENDA :
			n = 3;
			break; // optional
		case CENA :
			n = 4;
			break; // optional
			// You can have any number of case statements.
		default : // Optional
			n = 0;
		}
		//comidas.add(n,unaComida); 
		comidas[n]=unaComida;
	}
}

