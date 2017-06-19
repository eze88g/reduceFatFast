package ar.com.reduceFatFast.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import lombok.Data;

@Entity
public @Data class DietaSemanal {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public boolean validacion;
	//public List<Dia> dias = new ArrayList<Dia>(); //TODO: Donde incluir la cantidad??
	@OneToMany
	public List<Dia> dias;
	
	public void agregarComida (Comida unaComida, Integer numeroDeDia, ComidaDelDia comidaDelDia){
		dias.set(numeroDeDia, new Dia(comidaDelDia, unaComida));
	}

	public Dia getDia(int j) {
		return this.getDias().get(j);
	}
	
}
