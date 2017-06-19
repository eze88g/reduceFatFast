package ar.com.reduceFatFast.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

@DiscriminatorColumn(name="NUTRICIONISTA")
@Entity
public @Data class Nutricionista extends Usuario {
	
	@OneToMany(mappedBy="nutricionista")
	private List<Grupo> grupo;
	
	protected Nutricionista(){}
	
	public Nutricionista(String nombre, int dni, GestorDeUsuario gestor) {
		super(nombre, dni);
	}

	public void crearGrupo(){
	}
	
	//Hay que implemtentar la b'usqueda del paciente
	public void agregarUnPacienteAlGrupo (Paciente paciente)
	{
		// TODO: Fix this method
		//Paciente paciente = gestor.buscarPaciente(dni);
//		this.getGrupo().get(0).agregarPaciente(paciente);
	}

	public void validarDieta()
	{
		// TODO: Fix this method
		DietaSemanal dieta = this.getGrupo().get(0).getDietaSemanal();
		dieta.setValidacion(true);
	}

}
