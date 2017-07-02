/**
 * 
 */
package ar.com.reduceFatFast.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Usuario;
import ar.com.reduceFatFast.service.ComidaService;
import ar.com.reduceFatFast.service.GrupoService;
import ar.com.reduceFatFast.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Matias
 *
 */
@Validated
@RestController
@ControllerAdvice
@Api(value="SetUp", description="Genera datos de pueba en la base de datos.")
public class SetUpController extends AbstractController {
	
    @Autowired
    private GrupoService grupoService;
    
    @Autowired
    private ComidaService comidaService;
    
    @Autowired
    private UsuarioService usuarioService;
 
    public GrupoService getGrupoService() {
		return grupoService;
	}

	public void setGrupoService(GrupoService grupoService) {
		this.grupoService = grupoService;
	}

	public ComidaService getComidaService() {
		return comidaService;
	}

	public void setComidaService(ComidaService comidaService) {
		this.comidaService = comidaService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	final String[] nombresComida = { "Pizza", "Milanesas", "Hamburguesa", "Ensalada", 
			"Sushi", "Sandwich", "Pancho", "Choripan", "Locro", "Empanadas",
			"Fideos", "Tacos", "Guiso", ""};
	
	final String[] variablesComida = { " al vapor", " a la parrila", " a las brazas", 
			" al natural", " raw", " a las finas hierbas"};
	
	final String[] ingredientes = { "Pan rallado", "Carne picada", "Agua", "Sal", 
			"Azucar", "Pimienta", "Orégano", "Lechuga", "Tomates", "Acelga",
			"Zanahoria", "Cebolla", "Aceite de oliva" , "Aceitunas",
			"Arroz", "Salsa de tomates", "Salchicas", "Queso", "Salame",
			"Leche", "Paleta", "Berenjenas", "Tapa de nalga", "Hinojo",
			"Ajo", "Huevo", "Arvejas", "Polenta"};
	
	final String[] unidades = { "unidad", "gr", "lt" }; 

	@ApiOperation(value = "Crea un conjunto de datos de prueba", response = Grupo.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Datos creados"),
	        @ApiResponse(code = 401, message = ""),
	        @ApiResponse(code = 403, message = ""),
	        @ApiResponse(code = 409, message = "Ocurrio un error al crear los datos")
	}
	)
	@RequestMapping(path="/datosPueba", method = RequestMethod.POST)
    public ResponseEntity<String> crearGrupo(){
		Nutricionista n1 = this.getUsuarioService().crearNutricionista("Jose Gonzalez", 12345671);
		
		if (null == n1) {
			return new ResponseEntity<String>("Los datos ya están cargados", HttpStatus.CONFLICT);
		}
		
		Nutricionista n2 = this.getUsuarioService().crearNutricionista("Clara Bustamente", 12345672);
		Nutricionista n3 = this.getUsuarioService().crearNutricionista("Nicole Bru", 12345673);
	
		Paciente p1 = this.getUsuarioService().crearPaciente("Marcelo Zetti", 22345671);
		Paciente p2 = this.getUsuarioService().crearPaciente("Graciela Ran", 22345672);
		Paciente p3 = this.getUsuarioService().crearPaciente("Luis Cuento", 22345673);
		Paciente p4 = this.getUsuarioService().crearPaciente("Araceli Cates", 22345674);
		Paciente p5 = this.getUsuarioService().crearPaciente("Fernando Pela", 22345675);
		
		Grupo g1 = this.getGrupoService().crearGrupo(n1.getId(), "");
		this.getGrupoService().agregarMiembro(n1.getId(), g1.getId(), p1.getId());
		this.generarDieta(g1, n1);
		
		Grupo g2 = this.getGrupoService().crearGrupo(n2.getId(), "");
		this.getGrupoService().agregarMiembro(n2.getId(), g2.getId(), p2.getId());
		this.getGrupoService().agregarMiembro(n2.getId(), g2.getId(), p3.getId());
		this.generarDieta(g2, n2);
		
		Grupo g3 = this.getGrupoService().crearGrupo(n3.getId(), "");
		this.getGrupoService().agregarMiembro(n3.getId(), g3.getId(), p4.getId());
		this.getGrupoService().agregarMiembro(n3.getId(), g3.getId(), p5.getId());
		this.generarDieta(g3, n3);
    	
    	return new ResponseEntity<String>("Datos generados", HttpStatus.OK);
    }
	
	private int numeroRandom(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}
	
	private String obtenerRandom(String[] lista) {
		int randomNum = numeroRandom(0, lista.length - 1);
		return lista[randomNum];
	}
	
	private long generarComida(Usuario usuario) {
		// Es aburrido ser data entry
		String nombreComida = obtenerRandom(nombresComida) + obtenerRandom(variablesComida);
		int calorias = numeroRandom(1, 500);
		
		Comida comida = this.getComidaService().crearComida(usuario.getId(), nombreComida, calorias);
		
		int cantIngredientes = numeroRandom(2, 5);
		for (int i = 0; i < cantIngredientes; i ++) {
			String ingrediente = obtenerRandom(ingredientes);
			int cantidad = numeroRandom(1, 500);
			String unidad = obtenerRandom(unidades);
			this.getComidaService().agregarIngrediente(usuario.getId(), comida.getId(), ingrediente, cantidad, unidad);
		}

		return comida.getId();
	}
	
	private void generarDieta(Grupo grupo, Nutricionista nutricionista) {
		for (long i = 0l; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				long idComida = generarComida(nutricionista);
				this.getGrupoService().agregarComidaADieta(grupo.getId(), idComida, i, j);
			}
		}
	}
}
