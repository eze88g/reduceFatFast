/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.dto.ComidaDto;
import ar.com.reduceFatFast.dto.IngredienteDto;
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
	
//	@Autowired
//	private UsuarioRepository usuarioRepository;
	
	private Sistema getSistema(){
		return repository.findOne(1l);
	}

	@org.springframework.transaction.annotation.Transactional
	public Comida crearComida(int idUsuario, String nombre, long cantidadCalorias) {
		Comida comida = new Comida(nombre);
		comida.setCantidadCalorias(cantidadCalorias);
		
		Sistema sistema = getSistema();
		sistema.agregarComida(comida);
		
		return comida;
	}

	@org.springframework.transaction.annotation.Transactional
	public Boolean editarComida(long idComida, int idUsuario, String nombre, long cantidadCalorias) {
		try{
			Comida comidaParaEditar = comidaRepository.findOne(idComida);
			comidaParaEditar.setNombre(nombre);
			comidaParaEditar.setCantidadCalorias(cantidadCalorias);
		}catch(Exception e){
			throw e;
		}
		return true;
	}
	
	@org.springframework.transaction.annotation.Transactional
	public Comida agregarIngrediente(int idUsuario, long idComida, String nombre, int cantidad, String medida) {
		Comida comidaParaEditar = null;
		try{
			comidaParaEditar = comidaRepository.findOne(idComida);
			comidaParaEditar.agregarIngrediente(nombre, cantidad, medida);
			
		}catch(Exception e){
			throw e;
		}
		return comidaParaEditar;
	}

	public List<ComidaDto> listarComidas() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IngredienteDto> listarIngredientes(long idComida) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eliminarComida(long idComida) {
		// TODO Auto-generated method stub
		return false;
	}

	public IngredienteDto obtenerIngrediente(long idComida, long idIngrediente) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eliminarIngrediente(long idComida, long idIngrediente) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean actualizarIngrediente(long idComida, long idIngrediente, String nombre, int cantidad,
			String medida) {
		// TODO Auto-generated method stub
		return false;
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
