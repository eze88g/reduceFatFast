package ar.com.reduceFatFast.model;

import java.util.HashSet;
import java.util.Set;

public class Paciente extends Usuario {

	private Set<Comida> comidas = new HashSet<Comida>();
	private Set<Ingrediente> ingredientes = new HashSet<Ingrediente>();
	public Grupo unGrupo;
	public DietaSemanal unaDieta;
	
	public Paciente(String nombre, int dni) {
		super(nombre, dni);
		// TODO Auto-generated constructor stub
	}

	void agregarIngrediente(Ingrediente unIngrediente, int unaCantidad, Comida unaComida ){
		unaComida.agregarIngrediente(unIngrediente, unaCantidad);
	}

	void crearIngrediente(String aName, int calorias){
		Ingrediente unIngrediente = new Ingrediente (aName, calorias);
		ingredientes.add(unIngrediente);
	}
	
	void crearComida(String aName){
		Comida unaComida = new Comida (aName);
		comidas.add(unaComida);
	}
	
//	void agregarComida (Comida unaComida, dia unDia, )
}

package ar.com.reduceFatFast.model;

import java.util.HashSet;
import java.util.Set;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;

public class Paciente extends Usuario {

	private Set<Comida> comidas = new HashSet<Comida>();
	//private Set<Ingrediente> ingredientes = new HashSet<Ingrediente>();
	public Grupo grupo;
	
	public Paciente(String nombre, int dni) {
		super(nombre, dni);
		// TODO Auto-generated constructor stub
	}
	
	public void setGrupo (Grupo unGrupo)
	{
		grupo = unGrupo;
	}
	
	public void agregarIngrediente(Ingrediente unIngrediente, int unaCantidad,String unaUnidad, Comida unaComida ){
		unaComida.agregarIngrediente(unIngrediente, unaCantidad, unaUnidad);
	}

	public Ingrediente crearIngrediente(String aName, int calorias){
		Ingrediente unIngrediente = new Ingrediente (aName, calorias);
		return(unIngrediente);
	}
	
	public Comida crearComida(String aName){
		Comida unaComida = new Comida (aName);
		return(unaComida);
		//comidas.add(unaComida);
	}
	
	public void agregarComida (Comida unaComida, Integer numeroDeDia, ComidaDelDia comidaDelDia ){
		if (grupo == null)
			System.out.println("Error: Grupo no asignado");
		else
		{
			grupo.getDietaSemanal().agregarComida(unaComida, numeroDeDia, comidaDelDia);
		}
	}
}

package ar.com.reduceFatFast.model;

import java.util.HashSet;
import java.util.Set;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;

public class Paciente extends Usuario {

	private Set<Comida> comidas = new HashSet<Comida>();
	//private Set<Ingrediente> ingredientes = new HashSet<Ingrediente>();
	public Grupo grupo;
	
	public Paciente(String nombre, int dni) {
		super(nombre, dni);
		// TODO Auto-generated constructor stub
	}
	
	public void setGrupo (Grupo unGrupo)
	{
		grupo = unGrupo;
	}
	
	public void agregarIngrediente(Ingrediente unIngrediente, int unaCantidad,String unaUnidad, Comida unaComida ){
		unaComida.agregarIngrediente(unIngrediente, unaCantidad, unaUnidad);
	}

	public Ingrediente crearIngrediente(String aName, int calorias){
		Ingrediente unIngrediente = new Ingrediente (aName, calorias);
		return(unIngrediente);
	}
	
	public Comida crearComida(String aName){
		Comida unaComida = new Comida (aName);
		return(unaComida);
		//comidas.add(unaComida);
	}
	
	public void agregarComida (Comida unaComida, Integer numeroDeDia, ComidaDelDia comidaDelDia ){
		if (grupo == null)
			System.out.println("Error: Grupo no asignado");
		else
		{
			grupo.getDietaSemanal().agregarComida(unaComida, numeroDeDia, comidaDelDia);
		}
	}
}

