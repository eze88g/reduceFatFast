/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Dia;
import ar.com.reduceFatFast.model.DietaSemanal;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Ingrediente;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.model.Usuario;
import ar.com.reduceFatFast.repository.ComidaRepository;
import ar.com.reduceFatFast.repository.DiaRepository;
import ar.com.reduceFatFast.repository.DietaSemanalRepository;
import ar.com.reduceFatFast.repository.GrupoRepository;
import ar.com.reduceFatFast.repository.IngredienteRepository;
import ar.com.reduceFatFast.repository.NutricionistaRepository;
import ar.com.reduceFatFast.repository.SistemaRepository;
import ar.com.reduceFatFast.repository.UsuarioRepository;
import lombok.Data;

/**
 * @author joaco
 *
 */
@Service
@Transactional
public @Data class TestService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	@Autowired
	private ComidaRepository comidaRepository;
	@Autowired
	private DiaRepository diaRepository;
	@Autowired
	private DietaSemanalRepository dietaRepository;
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	@Autowired
	private GrupoRepository grupoRepository;
	@Autowired
	private SistemaRepository sistemaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private GeneralRepository repository;

	public void addIngrediente(Ingrediente i) {
		this.getIngredienteRepository().save(i);		
	}

	public List<Ingrediente> getAllIngredientes() {
		return (List<Ingrediente>) this.getIngredienteRepository().findAll();
	}

	public Ingrediente getIngrediente(Long i) {
		return this.getIngredienteRepository().findOne(i);
	}

	public void add(Ingrediente ingredienteComida) {
		this.getIngredienteRepository().save(ingredienteComida);
	}

	public Ingrediente getIngredienteComida(long l) {
		return this.getIngredienteRepository().findOne(l);
	}

	public void add(Comida comida) {
		this.getComidaRepository().save(comida);
	}

	public List<Comida> getAllComidas() {
		return (List<Comida>) this.getComidaRepository().findAll();
	}

	public void add(Dia dia) {
		this.getDiaRepository().save(dia);	
	}
	
	public List<Dia> getAllDias() {
		return (List<Dia>) this.getDiaRepository().findAll();	
	}

	public void add(DietaSemanal dieta) {
		this.getDietaRepository().save(dieta);	
	}
	
	public List<DietaSemanal> getDietas() {
		return (List<DietaSemanal>) this.getDietaRepository().findAll();	
	}

	public void add(Nutricionista nutricionista) {
		this.getNutricionistaRepository().save(nutricionista);
		
	}
	
	public List<Nutricionista> getNutricionistas(){
		return (List<Nutricionista>) this.getNutricionistaRepository().findAll();
	}

	public void add(Grupo grupo) {
		this.getGrupoRepository().save(grupo);		
	}
	
	public List<Grupo> getGrupos(){
		return (List<Grupo>) this.getGrupoRepository().findAll();
	}

	public Sistema actualizarSistema() {
		Sistema sistema = this.getSistemaRepository().findOne(1l);
		List<Comida> comidas = this.getAllComidas();
		List<Usuario> usuarios = (List<Usuario>) this.getUsuarioRepository().findAll();
		List<Grupo> grupos = (List<Grupo>) this.getGrupoRepository().findAll();
		sistema.getComidas().addAll(comidas);
		sistema.getGrupos().addAll(grupos);
		sistema.getUsuarios().addAll(usuarios);
		this.getSistemaRepository().save(sistema);
		return sistema;
	}
}
