package ar.com.reduceFatFast.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Value;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import lombok.Data;

@Entity
public @Data class Dia {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Version
	private long version;
	@Value("${modelo.cantidadComidasPorDia}")
	private Integer cantidadComidasPorDia;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Comida> comidas;
	
	public Dia() {
		this.setComidas(new ArrayList<Comida>());
//		for (int i=0; i<4; i++){
//			comidas.add(new Comida());
//		}
	}

	public Dia(ComidaDelDia comidaDelDia, Comida unaComida) {
		this();
		this.setComida(comidaDelDia, unaComida);
	}

	public Comida getComida(Integer n) {
		return ((ArrayList<Comida>)this.getComidas()).get(n);
	}

	public Comida getComida(ComidaDelDia comidaDelDia) {
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
		return (this.getComidas().get(n));
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
		this.getComidas().set(n, unaComida);
	}
}

