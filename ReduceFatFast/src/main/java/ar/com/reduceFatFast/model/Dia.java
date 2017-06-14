package ar.com.reduceFatFast.model;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;

public class Dia {

	private List<Comida> comidas = new ArrayList<Comida>();
	
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
		comidas.add(n,unaComida);
	}
}


=======
public class Dia {

	Comida desayuno;
	Comida almuerzo;
	Comida merienda;
	Comida cena;
	
	public Comida getDesayuno() {
		return desayuno;
	}
	public void setDesayuno(Comida desayuno) {
		this.desayuno = desayuno;
	}
	public Comida getAlmuerzo() {
		return almuerzo;
	}
	public void setAlmuerzo(Comida almuerzo) {
		this.almuerzo = almuerzo;
	}
	public Comida getMerienda() {
		return merienda;
	}
	public void setMerienda(Comida merienda) {
		this.merienda = merienda;
	}
	public Comida getCena() {
		return cena;
	}
	public void setCena(Comida cena) {
		this.cena = cena;
	}
}
>>>>>>> 7a395380006c97e5603c6fcbf251b8a6891f4ae4
