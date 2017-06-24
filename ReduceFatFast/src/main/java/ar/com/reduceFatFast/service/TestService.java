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
import ar.com.reduceFatFast.model.Ingrediente;
import ar.com.reduceFatFast.repository.ComidaRepository;
import ar.com.reduceFatFast.repository.DiaRepository;
import ar.com.reduceFatFast.repository.DietaSemanalRepository;
import ar.com.reduceFatFast.repository.IngredienteRepository;
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
}
