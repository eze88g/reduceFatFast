package ar.com.reduceFatFast.model;

import java.util.HashSet;
import java.util.Set;

public class GestorDeUsuario {
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	private Set<Grupo> grupos = new HashSet<Grupo>();
	
	Grupo crearGrupo (Nutricionista unNutricionista){
		Grupo grupo = new Grupo (unNutricionista);
		grupos.add(grupo);
		return (grupo);
	}

	public Paciente buscarPaciente(String dni) {
		//Busca paciente a partir de dni
		return null;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
}
