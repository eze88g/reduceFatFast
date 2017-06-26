package ar.com.reduceFatFast.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@DiscriminatorColumn(name="NUTRICIONISTA")
@Entity
public @Data class Nutricionista extends Usuario {
	@OneToMany(mappedBy="nutricionista")
	private List<Grupo> grupos;
	
	protected Nutricionista(){}
	
	public Nutricionista(String nombre, int dni, Sistema sistema) {
		super(nombre, dni, sistema);
		this.setGrupos(new ArrayList<Grupo>());
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
	
	public boolean borrarGrupo (Grupo unGrupo){
		if ( grupos.contains(unGrupo) ){
			grupos.remove(unGrupo);
			sistema.borrarGrupo(unGrupo);
			return true;
		}
		else 
			return false;
	}
	
	public Grupo crearGrupo(String unNombre){
		for (int i=0;i<grupos.size();i++){
			if (unNombre == grupos.get(i).getNombre()){
				return null;
			}
		}
		Grupo unGrupo = new Grupo (this,unNombre);
		grupos.add(unGrupo);
		sistema.agregarGrupo(unGrupo);
		return unGrupo;
	}
	
	//Hay que implemtentar la b'usqueda del paciente
	public void agregarUnPacienteAlGrupo (Paciente paciente)
	{
		// TODO: Fix this method
		//Paciente paciente = gestor.buscarPaciente(dni);
//		this.getGrupo().get(0).agregarPaciente(paciente);
	}
/*
	public void validarDieta()
	{
		// TODO: Fix this method
		DietaSemanal dieta = this.getGrupos().get(0).getDietaSemanal();
		dieta.setValidacion(true);
	}
*/
}
