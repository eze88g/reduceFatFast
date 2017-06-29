package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

@DiscriminatorColumn(name="NUTRICIONISTA")
@Entity
public @Data class Nutricionista extends Usuario {
	@OneToMany(mappedBy="nutricionista")
	private List<Grupo> grupos;
	
	protected Nutricionista(){}
	
	public Nutricionista(String nombre, int dni) {
		super(nombre, dni);
		this.setGrupos(new ArrayList<Grupo>());
	}
	
	public void agregarGrupo(Grupo unGrupo){
		grupos.add(unGrupo);
	}
	
	public boolean borrarGrupo(Grupo unGrupo){
		if ( grupos.contains(unGrupo) ){
			grupos.remove(unGrupo);	
			return true;
		}
		else
			return false;
	}
	
	public Grupo buscarGrupo (String unNombre){
		Grupo grupo = null;
		for (int i=0;i<grupos.size();i++){
			if (unNombre == grupos.get(i).getNombre()){
				grupo = grupos.get(i);
			}
		}
		return grupo;
	}
}
