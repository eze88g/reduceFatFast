package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.Data;

@Entity
public @Data class Sistema {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Version
	private long version;
	private String nombre;
	private Date startedDate;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="SISTEMA_ID")
	private List<Comida> comidas;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="SISTEMA_ID")
	private List<Usuario> usuarios;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="SISTEMA_ID")
	private List<Grupo> grupos;
	
	public Sistema(){
		this.setComidas(new ArrayList<Comida>());
		this.setUsuarios(new ArrayList<Usuario>());
		this.setGrupos(new ArrayList<Grupo>());
	}
	
	void agregarComida (Comida unaComida){
		comidas.add(unaComida);
	}
	
}
