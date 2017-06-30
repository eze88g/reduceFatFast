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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.dto.NutricionistaDto;
import ar.com.reduceFatFast.dto.PacienteDto;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;
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
@Api(value="Usuarios", description="Operaciones relacionadas con la administracion de usuarios")
public class UsuarioController extends AbstractController{
	
    @Autowired
    private UsuarioService usuarioService;
    
    public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
 
	@ApiOperation(value = "Crea un Nutricionista", response = NutricionistaDto.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El nutricionista fue creado satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear un nuevo nutricionista"),
	        @ApiResponse(code = 403, message = "El acceso a la creacion de nutricionistas se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de crear un nuevo nutricionista")
	}
	)
    @RequestMapping(path="/nutricionistas", method = RequestMethod.POST)
    public ResponseEntity<NutricionistaDto> crearNutricionista(String nombre, int dni){
    	
    	Nutricionista nutricionista = this.getUsuarioService().crearNutricionista(nombre, dni); 
    	
    	if (null != nutricionista) {
    		return new ResponseEntity<NutricionistaDto>(new NutricionistaDto(nutricionista), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<NutricionistaDto>(HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "Retorna una lista de Nutricionistas", response = NutricionistaDto.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "La lista de nutricionistas fue creada satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para generar un listado de nutricionistas"),
	        @ApiResponse(code = 403, message = "El acceso al listado de nutricionistas se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de obtener el listado de nutricionista")
	}
	)
    @RequestMapping(path="/nutricionistas", method = RequestMethod.GET)
    public ResponseEntity<List<NutricionistaDto>> listarNutricionistas(){
    	
    	Iterable<Nutricionista> result = this.getUsuarioService().listarNutricionistas();
    	
    	List<NutricionistaDto> nutricionistas = new ArrayList<NutricionistaDto>();
    	
    	for (Nutricionista each : result) {
    		nutricionistas.add(new NutricionistaDto(each));
    	}
    	
    	return new ResponseEntity<>(nutricionistas, HttpStatus.OK);
    }
    
	@ApiOperation(value = "Crea un Paciente", response = PacienteDto.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El nutricionista fue creado satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear un nuevo nutricionista"),
	        @ApiResponse(code = 403, message = "El acceso a la creacion de nutricionistas se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de crear un nuevo nutricionista")
	}
	)
    @RequestMapping(path="/pacientes", method = RequestMethod.POST)
    public ResponseEntity<PacienteDto> crearPaciente(String nombre, int dni){
    	
    	Paciente paciente = this.getUsuarioService().crearPaciente(nombre, dni); 
    	
    	if (null != paciente) {
    		return new ResponseEntity<PacienteDto>(new PacienteDto(paciente), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<PacienteDto>(HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "Crea una lista de Pacientes", response = PacienteDto.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "La lista de nutricionistas fue creada satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una lista de nutricionista"),
	        @ApiResponse(code = 403, message = "El acceso a la lista de nutricionistas se encuentra prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de crear un listado de nutricionista")
	}
	)
    @RequestMapping(path="/pacientes", method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDto>> listarPacientes(){
    	
    	Iterable<Paciente> result = this.getUsuarioService().listarPacientes();
    	
    	List<PacienteDto> pacientes = new ArrayList<PacienteDto>();
    	
    	for (Paciente each : result) {
    		pacientes.add(new PacienteDto(each));
    	}
    	
    	return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    
    

}
