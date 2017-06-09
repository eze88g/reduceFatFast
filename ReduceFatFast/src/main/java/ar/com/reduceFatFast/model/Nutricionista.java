package ar.com.reduceFatFast.model;

import java.util.HashSet;
import java.util.Set;

public class Nutricionista extends Usuario {
	private Grupo grupo;
	private GestorDeUsuario gestor;
	
	
	public Nutricionista(String nombre, int dni, GestorDeUsuario gestor) {
		super(nombre, dni);
		this.gestor = gestor;
	}

	public void crearGrupo(){
		grupo = gestor.crearGrupo(this);
	}
	
	//Hay que implemtentar la b'usqueda del paciente
	public void agregarUnPacienteAlGrupo (Paciente paciente)
	{
		//Paciente paciente = gestor.buscarPaciente(dni);
		grupo.agregarPaciente(paciente);
	}

	public void validarDieta()
	{
		DietaSemanal dieta = grupo.getDietaSemanal();
		dieta.setValidacion(true);
	}
	
	public Grupo getGrupo() {
		return grupo;
	}

}
