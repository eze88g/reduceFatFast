package ar.com.reduceFatFast.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public @Data class Grupo {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	@OneToMany
	private List<Paciente> pacientes;
	@ManyToOne
	private Nutricionista nutricionista;
	@ManyToOne
	private DietaSemanal dietaSemanal;

	
	public Grupo(Nutricionista nutricionista) {
		this.setNutricionista(nutricionista);
		this.setDietaSemanal(new DietaSemanal());
	}
	
	public void agregarPaciente(Paciente unPaciente){
		pacientes.add(unPaciente);
		unPaciente.setGrupo(this);
	}

	public void quitarPaciente(Paciente unPaciente){
		pacientes.remove(unPaciente);
	}

}
