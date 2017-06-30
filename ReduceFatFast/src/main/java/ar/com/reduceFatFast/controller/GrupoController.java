/**
 * 
 */
package ar.com.reduceFatFast.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.dto.DietaSemanalDto;
import ar.com.reduceFatFast.dto.GrupoDto;
import ar.com.reduceFatFast.dto.PacienteDto;
import ar.com.reduceFatFast.model.DietaSemanal;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.service.GrupoService;
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
@Api(value="Grupo", description="Operaciones relacionadas con la administracion de la Grupos")
public class GrupoController extends AbstractController {
	
    @Autowired
    private GrupoService grupoService;
 
    public GrupoService getGrupoService() {
		return grupoService;
	}

	public void setGrupoService(GrupoService grupoService) {
		this.grupoService = grupoService;
	}

	@ApiOperation(value = "Crea un grupo de pacientes nuevo", response = Grupo.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El grupo fue creado de forma satisfactoria"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear un grupo"),
	        @ApiResponse(code = 403, message = "El acceso a la creacion de grupos se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de crear el grupo")
	}
	)
	@RequestMapping(path="/grupos", method = RequestMethod.POST)
    public ResponseEntity<GrupoDto> crearGrupo(long idUsuario, String nombre){
		Grupo grupo = this.getGrupoService().crearGrupo(idUsuario, nombre); 
    	if (grupo != null) {
    		return new ResponseEntity<GrupoDto>(new GrupoDto(grupo), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<GrupoDto>(HttpStatus.CONFLICT);
    	}
    }
	
	@ApiOperation(value = "Retorna una lista con los grupos existentes en el sistema", response = Grupo.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El listado se obtuvo satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para obtener un listado de los grupos del sistema"),
	        @ApiResponse(code = 403, message = "El acceso al listado de grupos se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de obtener un listado de grupos")
	}
	)
	@RequestMapping(path="/grupos", method = RequestMethod.GET)
    public ResponseEntity<List<GrupoDto>> listarGrupos(){
		
//		Iterable<Grupo> result = this.getGrupoService().listarGrupos();
//		
//		List<GrupoDto> grupos = new ArrayList<GrupoDto>();
//		for (Grupo each : result) {
//			grupos.add(new GrupoDto(each));
//		}
		
		return new ResponseEntity<>(this.getGrupoService().listarGrupos(), HttpStatus.OK);
    }
    
	@ApiOperation(value = "A partir un grupo ya creado, se agrega un paciente", response = String.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El paciente fue creado y agregado satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para agregar un paciente al grupo"),
	        @ApiResponse(code = 403, message = "El acceso al agregado de pacientes se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de agregar un paciente a un grupo")
	}
	)
    @RequestMapping(path="/grupos/{idGrupo}/miembros", method = RequestMethod.POST)
    public ResponseEntity<String> agregarPaciente(@PathVariable("idGrupo") long idGrupo, long idPaciente, long idUsuario){
    	if (this.getGrupoService().agregarMiembro(idUsuario, idGrupo, idPaciente)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Miembro no agregado al grupo", HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "A partir un grupo ya creado, se obtiene una lista de los pacientes", response = String.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El listado fue generado satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para conocer los pacientes de un grupo"),
	        @ApiResponse(code = 403, message = "El acceso al listado de pacientes se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de obtener un listado de pacientes")
	}
	)
    @RequestMapping(path="/grupos/{idGrupo}/miembros", method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDto>> listarPacientes(@PathVariable("idGrupo") long idGrupo){
    	
    	List<Paciente> result = this.getGrupoService().listarMiembros(idGrupo);
    	
    	List<PacienteDto> pacientes = new ArrayList<>();
    	
    	for (Paciente each : result) {
    		pacientes.add(new PacienteDto(each));
    	}
    	
    	return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
	
	@ApiOperation(value = "Retorna la Dieta que esta siendo usada por un grupo", response = String.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "La dieta fue obtenida satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para conocer la dieta de un grupo"),
	        @ApiResponse(code = 403, message = "El acceso a la dieta de un grupo se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de obtener la dieta de un grupo")
	}
	)
    @RequestMapping(path="/grupos/{idGrupo}/dieta", method = RequestMethod.GET)
    public ResponseEntity<DietaSemanalDto> obtenerDieta(@PathVariable("idGrupo") long idGrupo){
    	DietaSemanal dieta = this.getGrupoService().obtenerDieta(idGrupo);
    	
    	if (dieta != null) {
    		return new ResponseEntity<>(new DietaSemanalDto(dieta), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "Un nutricionista valida acepta la dieta propuesta para realizar por un grupo", response = String.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "La dieta fue validada satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para validar la dieta de un grupo"),
	        @ApiResponse(code = 403, message = "La validacion de la dieta de un grupo se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de validar la dieta de un grupo")
	}
	)
    @RequestMapping(path="/grupos/{idGrupo}/dieta/validar", method = RequestMethod.POST)
    public ResponseEntity<String> validarDieta(@PathVariable("idGrupo") long idGrupo, long idNutricionista){
    	if (this.getGrupoService().validarDieta(idGrupo, idNutricionista)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Dieta no validada", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/grupos/{idGrupo}/dieta/comidas", method = RequestMethod.POST)
    public ResponseEntity<String> agregarComidaADieta(@PathVariable("idGrupo") long idGrupo, long idComida, Integer dia, int comidaDelDia){
    	this.getGrupoService().agregarComidaADieta(idGrupo, idComida, dia, comidaDelDia);
		
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
