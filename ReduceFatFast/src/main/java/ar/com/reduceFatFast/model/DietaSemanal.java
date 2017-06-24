package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import lombok.Data;

@Entity
public @Data class DietaSemanal {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public boolean validacion;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="DIETA_ID")
	public List<Dia> dias;
	
	public void agregarComida (Comida unaComida, Integer numeroDeDia, ComidaDelDia comidaDelDia){
		if(this.dias.get(numeroDeDia) != null){
			Dia selected = dias.get(numeroDeDia);
			selected.setComida(comidaDelDia, unaComida);
			this.dias.set(numeroDeDia, selected);
		}else{
			dias.set(numeroDeDia, new Dia(comidaDelDia, unaComida));
		}
		
	}
	
	public void agregarDia(Dia dia, Integer pos){
		this.getDias().add(pos, dia);
	}
	
	public void agregarDias(List<Dia> dias){
		this.getDias().addAll(dias);
	}

	public Dia getDia(int j) {
		return this.getDias().get(j);
	}
	
	public DietaSemanal(){
		this.setDias(new ArrayList<Dia>());
	}
	
}