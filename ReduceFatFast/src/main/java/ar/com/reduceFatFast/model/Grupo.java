package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public @Data class Grupo {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	@Version
	private long version;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Paciente> pacientes;
	@JsonIgnore
	@ManyToOne
	private Nutricionista nutricionista;
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private DietaSemanal dietaSemanal;
	private String nombre;

	protected Grupo(){}
	
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
	
	public boolean validarDieta(Nutricionista nutricionista) {
		
		if (this.getNutricionista().equals(nutricionista) && !this.getDietaSemanal().isValidacion()) {
			this.getDietaSemanal().setValidacion(true);
			return true;
		}
		
		return false;
	}

}
