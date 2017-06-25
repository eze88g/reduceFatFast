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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public @Data class Grupo {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	@OneToMany(mappedBy="grupo")
	private List<Paciente> pacientes;
	@ManyToOne
	private Nutricionista nutricionista;
	@ManyToOne
	private DietaSemanal dietaSemanal;
	private String nombre ;

	
	public Grupo(Nutricionista nutricionista, String unNombre) {
		this.setNutricionista(nutricionista);
		this.setDietaSemanal(new DietaSemanal());
		this.setNombre(unNombre);
		this.setPacientes(new ArrayList<Paciente>());
	}
	
	public void agregarPaciente(Paciente unPaciente){
		pacientes.add(unPaciente);
		unPaciente.setGrupo(this);
	}

	public void quitarPaciente(Paciente unPaciente){
		pacientes.remove(unPaciente);
	}

}
