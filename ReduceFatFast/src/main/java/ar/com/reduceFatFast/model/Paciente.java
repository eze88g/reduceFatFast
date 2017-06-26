package ar.com.reduceFatFast.model;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import lombok.Data;

@Entity
@DiscriminatorColumn(name="PACIENTE")
public @Data class Paciente extends Usuario {

	@ManyToMany
	private Set<Comida> comidas;

	@ManyToOne
    @JoinColumn(name="troop_fk")
	public Grupo grupo;
	
	public Paciente(String nombre, int dni, Sistema sistema) {
		super(nombre, dni, sistema);
	}
	
	public void setGrupo (Grupo unGrupo)
	{
		grupo = unGrupo;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void agregarIngrediente(String nombre, int unaCantidad,String unaUnidad, Comida unaComida ){
		unaComida.agregarIngrediente(nombre, unaCantidad, unaUnidad);
	}

	public Ingrediente crearIngrediente(String aName,int cantidad, String unidad){
		Ingrediente unIngrediente = new Ingrediente (aName, cantidad, unidad);
		return(unIngrediente);
	}
	
	public Comida crearComida(String aName){
		Comida unaComida = new Comida (aName);
		this.getSistema().agregarComida(unaComida);
		return(unaComida);
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

