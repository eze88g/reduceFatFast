package ar.com.reduceFatFast.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import lombok.Data;

@Entity
public @Data class DietaSemanal {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Version
	private long version;
	public boolean validacion;
	
	@OneToMany(cascade=CascadeType.PERSIST) @JoinColumn(name="id") @MapKey(name="id")
	private Map<Integer,Dia> dias;
	
	public DietaSemanal () {
		this.setDias(new HashMap<Integer,Dia>());
	}
	
	public void agregarComida (Comida unaComida, Integer numeroDia, ComidaDelDia comidaDelDia){
		if (dias.containsKey(numeroDia) != true )
			dias.put(numeroDia,new Dia());
		dias.get(numeroDia).setComida(comidaDelDia, unaComida);
	}
	
	public void agregarDia(Dia dia, Integer pos){
		this.getDias().put(pos, dia);
	}
	
	public void agregarDias(Map<Integer,Dia> dias){
		this.getDias().putAll(dias);
	}

	public Dia getDia(int j) {
		return this.getDias().get(j);
	}
	
}
