/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.dto.ComidaDto;
import ar.com.reduceFatFast.dto.IngredienteDto;

/**
 * @author Matias
 *
 */
@Service
@Configuration
public class ComidaService {

	
//	@Autowired
//	private UsuarioRepository usuarioRepository;

	public boolean crearComida(int idUsuario, String nombre, long cantidadCalorias) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editarComida(long idComida, int idUsuario, String nombre, long cantidadCalorias) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean agregarIngrediente(int idUsuario, long idComida, String nombre, int cantidad, String medida) {
		// TODO Auto-generated method stub
		return false;
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
	
}
