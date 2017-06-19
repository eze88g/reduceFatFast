package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
public @Data class Sistema {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nombre;
	private Date startedDate;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Comida> comidas;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Usuario> usuarios;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Grupo> grupos;
	
	public Sistema(){
		this.setComidas(new ArrayList<Comida>());
		this.setUsuarios(new ArrayList<Usuario>());
		this.setGrupos(new ArrayList<Grupo>());
	}
}
