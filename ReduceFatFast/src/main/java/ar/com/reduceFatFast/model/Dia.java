package ar.com.reduceFatFast.model;


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
import javax.persistence.MapKeyColumn;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Value;

import ar.com.reduceFatFast.exception.ParametrosInvalidos;
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
	@ManyToMany(cascade=CascadeType.PERSIST) @JoinColumn(name="id")
	@MapKeyColumn(name="numeroComida")
	private Map<Long,Comida> comidas;
	private long numeroDia;
	
	public Dia() {
		this.setComidas(new HashMap<Long,Comida>());
	}

	public Dia(ComidaDelDia comidaDelDia, Comida unaComida) {
		this();
		this.setComida(comidaDelDia, unaComida);
	}

	public Comida getComida(ComidaDelDia comidaDelDia) {
		Long n ;
		switch(comidaDelDia) {
		case DESAYUNO :
			n = 0l;
			break;
		case ALMUERZO :
			n = 1l;
			break;
		case MERIENDA :
			n = 2l;
			break;
		case CENA :
			n = 3l;
			break;
		default :
			throw new ParametrosInvalidos("Parámetro inválido para la comida del dia");
		}
		return (this.getComidas().get(n));
	}
	
	
	public void setComida(ComidaDelDia comidaDelDia, Comida unaComida) {
		Long n ;
		switch(comidaDelDia) {
		case DESAYUNO :
			n = 0l;
			break;
		case ALMUERZO :
			n = 1l;
			break;
		case MERIENDA :
			n = 2l;
			break;
		case CENA :
			n = 3l;
			break;
		default :
			n = 0l;
		}
		this.getComidas().put(n, unaComida);
	}
}

