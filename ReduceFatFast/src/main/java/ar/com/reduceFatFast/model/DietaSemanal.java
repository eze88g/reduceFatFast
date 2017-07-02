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

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import lombok.Data;

@Entity
public @Data class DietaSemanal {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Version
	private long version;
	public boolean validacion;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@MapKeyColumn(name="numeroDia")
	private Map<Long,Dia> dias;
	
	public DietaSemanal () {
		this.setDias(new HashMap<Long,Dia>());
	}
	
	public void agregarComida (Comida unaComida, Long numeroDia, ComidaDelDia comidaDelDia){
		if (dias.containsKey(numeroDia) != true ) {
			Dia dia = new Dia();
			dia.setNumeroDia(numeroDia);
			dias.put(numeroDia, dia);
		}
			
		dias.get(numeroDia).setComida(comidaDelDia, unaComida);
	}
	
	public void agregarDia(Dia dia, Long pos){
		this.getDias().put(pos, dia);
	}

	public Dia getDia(Long j) {
		return this.getDias().get(j);
	}
	
}
