package ar.com.reduceFatFast.model;

import java.util.HashSet;
import java.util.Set;

public class Grupo {
	
	private String oid;
	private Set<Paciente> pacientes = new HashSet<Paciente>();
	private Nutricionista unNutricionista;
	private DietaSemanal unaDietaSemanal;

	
	public Grupo(Nutricionista unNutricionista) {
		this.unNutricionista = unNutricionista;
	}
	
	public void agregarPaciente(Paciente unPaciente){
		pacientes.add(unPaciente);
		unPaciente.setGrupo(this);
	}

	public void quitarPaciente(Paciente unPaciente){
		pacientes.remove(unPaciente);
	}
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}
/*
	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
*/
	public Nutricionista getNutricionista() {
		return unNutricionista;
	}

	public void setNutricionista(Nutricionista unNutricionista) {
		this.unNutricionista = unNutricionista;
	}

	public DietaSemanal getDietaSemanal() {
		return unaDietaSemanal;
	}

	public void setDietaSemanal(DietaSemanal unaDietaSemanal) {
		this.unaDietaSemanal = unaDietaSemanal;
	}
}
