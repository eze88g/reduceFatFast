/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.reduceFatFast.dto.ComidaDto;
import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Ingrediente;
import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.repository.ComidaRepository;
import ar.com.reduceFatFast.repository.SistemaRepository;

/**
 * @author Matias
 *
 */
@Service
@Configuration
public class ComidaService {

	@Autowired
	private SistemaRepository repository;
	@Autowired
	private ComidaRepository comidaRepository;
	
	private Sistema getSistema(){
		return repository.findOne(1l);
	}

	@Transactional
	public Comida crearComida(int idUsuario, String nombre, long cantidadCalorias) {
		Comida comida = new Comida(nombre);
		comida.setCantidadCalorias(cantidadCalorias);
		
		Sistema sistema;
		synchronized(sistema = getSistema()) {
			sistema.agregarComida(comida);
			return comida;
		}	
	}

	@Transactional
	public Comida editarComida(long idComida, int idUsuario, String nombre, long cantidadCalorias) throws Exception {
		Comida comidaParaEditar;
		try{
			comidaParaEditar = comidaRepository.findOne(idComida);
			synchronized (comidaParaEditar){
				comidaParaEditar.setNombre(nombre);
				comidaParaEditar.setCantidadCalorias(cantidadCalorias);
			}
		}catch(Exception e){
			throw e;
		}
		return comidaParaEditar;
	}
	
	@Transactional
	public Comida agregarIngrediente(int idUsuario, long idComida, String nombre, int cantidad, String medida) {
		Comida comidaParaEditar = null;
		try{
			comidaParaEditar = comidaRepository.findOne(idComida);
			synchronized (comidaParaEditar){
				comidaParaEditar.agregarIngrediente(nombre, cantidad, medida);
			}			
		}catch(Exception e){
			throw e;
		}
		return comidaParaEditar;
	}

	synchronized public List<Comida> listarComidas() {
		return (List<Comida>) this.comidaRepository.findAll();
	}

	synchronized public List<Ingrediente> listarIngredientes(long idComida) {
		try{
			Comida comida = this.comidaRepository.findOne(idComida);
			if(comida!=null){
				return comida.getIngredientes();
			}else{
				return null;
			}
		}catch(Exception e){
			throw e;
		}
	}

	@Transactional
	synchronized public boolean eliminarComida(long idComida) {
		Sistema sistema = this.repository.findOne(1l);
		Comida comida = this.comidaRepository.findOne(idComida);		
		synchronized(sistema){
			Integer i = sistema.getComidas().indexOf(comida);
			sistema.getComidas().remove(comida);
		}	
		return true;
	}

	public Optional<Ingrediente> obtenerIngrediente(long idComida, long idIngrediente) {
		List<Ingrediente> ingredientes = this.listarIngredientes(idComida);
		return ingredientes.stream().filter(x -> x.getId()==idIngrediente).findFirst();
	}

	@Transactional
	synchronized public boolean eliminarIngrediente(long idComida, long idIngrediente){
		Comida comida = this.comidaRepository.findOne(idComida);
		if(comida!=null){
			Optional<Ingrediente> ingrediente = comida.getIngredientes().stream().filter(x -> x.getId()==idIngrediente).findFirst();
			comida.getIngredientes().remove((Ingrediente)ingrediente.get());
		}
		return true;
	}

	@Transactional
	synchronized public Comida actualizarIngrediente(long idComida, long idIngrediente, String nombre, int cantidad,
			String medida) {
		Comida comida = this.comidaRepository.findOne(idComida);
		List<Ingrediente> ingredientes = this.listarIngredientes(idComida).stream().filter(x -> x.getId() == idIngrediente).collect(Collectors.toList());
		for (Ingrediente ingrediente : ingredientes) {
			Integer i = comida.getIngredientes().indexOf(ingrediente);
			comida.getIngredientes().get(i).setName(nombre);
			comida.getIngredientes().get(i).setCantidad(cantidad);
			comida.getIngredientes().get(i).setUnidad(medida);
		}
		return comida;
	}

	/**
	 * @return the repository
	 */
	public SistemaRepository getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(SistemaRepository repository) {
		this.repository = repository;
	}
	
}
