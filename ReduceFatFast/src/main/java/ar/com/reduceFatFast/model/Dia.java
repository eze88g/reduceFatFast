package ar.com.reduceFatFast.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
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
	private Integer numeroDia;
//	@ManyToMany(cascade = CascadeType.PERSIST)
//	private List<Comida> comidas;
	@ManyToMany(cascade=CascadeType.PERSIST) @JoinColumn(name="id") @MapKey(name="id")
	private Map<Integer,Comida> comidas;
	
	public Dia(Integer unNumeroDia) {
		//this.setComidas(new ArrayList<Comida>());
		this.setComidas(new HashMap<Integer,Comida>());
		numeroDia = unNumeroDia;
//		for (int i=0; i<4; i++){
//			comidas.add(null);
//		}
	}

	public Dia(ComidaDelDia comidaDelDia, Comida unaComida, Integer unNumeroDia) {
		this(unNumeroDia);
		this.setComida(comidaDelDia, unaComida);
	}

	public Comida getComida(Integer n) {
		return ((ArrayList<Comida>)this.getComidas()).get(n);
	}

	public Comida getComida(ComidaDelDia comidaDelDia) {
		int n ;
		switch(comidaDelDia) {
		case DESAYUNO :
			n = 0;
			break; // optional
		case ALMUERZO :
			n = 1;
			break; // optional
		case MERIENDA :
			n = 2;
			break; // optional
		case CENA :
			n = 3;
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
			n = 0;
			break; // optional
		case ALMUERZO :
			n = 1;
			break; // optional
		case MERIENDA :
			n = 2;
			break; // optional
		case CENA :
			n = 3;
			break; // optional
			// You can have any number of case statements.
		default : // Optional
			n = 0;
		}
		this.getComidas().put(n, unaComida);
	}
}

