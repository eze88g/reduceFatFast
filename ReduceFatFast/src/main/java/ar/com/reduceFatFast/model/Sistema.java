package ar.com.reduceFatFast.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	//TODO: como hacemos el loguin? Una clase aparte del sistema?

	public Usuario buscarUsuarioByDni (int unDni){
		Usuario usuario = null;
		for (int i=0;i<usuarios.size();i++){
			if (unDni == usuarios.get(i).getDni()){
				usuario = usuarios.get(i);
			}
		}
		return usuario;
	}
	public boolean agregarUsuario (Usuario unUsuario){
		if (this.buscarUsuarioByDni(unUsuario.getDni())==null){
			usuarios.add(unUsuario);
			return true;
		}
		else
			return false;
	}
	public void borrarUsuario (Usuario unUsuario){
		usuarios.remove(unUsuario);
	}
	public void agregarComida (Comida unaComida){
		comidas.add(unaComida);
	}
	public void agregarGrupo (Grupo unGrupo){
		grupos.add(unGrupo);
	}
	public void borrarGrupo (Grupo unGrupo){
		grupos.remove(unGrupo);
	}
}
