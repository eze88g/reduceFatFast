/**
 * 
 */
package ar.com.reduceFatFast.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Ingrediente;
import ar.com.reduceFatFast.service.ComidaService;
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
@Api(value="Comida", description="Operaciones relacionadas con la administracion de la comida")
public class ComidaController extends AbstractController{
	
    @Autowired
    private ComidaService comidaService;
    
    public ComidaService getComidaService() {
		return comidaService;
	}

	public void setComidaService(ComidaService comidaService) {
		this.comidaService = comidaService;
	}
 
	@ApiOperation(value = "Crea una comida nueva", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Comida creada satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un problema tratando de crear la comida")
	}
	)
    @RequestMapping(path="/comidas", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Comida> crearComida(int idUsuario, String nombre, long cantidadCalorias){
    	Comida comida = this.getComidaService().crearComida(idUsuario, nombre, cantidadCalorias);
    	if (comida.getId()!=0) {
    		ResponseEntity response = new ResponseEntity<>(comida, HttpStatus.OK);
    		return response;
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "Retorna la lista de comidas existentes en el sistema", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "se genero la lista de comidas satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un problema tratando de obtener la lista de comidas")
	}
	)
    @RequestMapping(path="/comidas", method = RequestMethod.GET)
    public ResponseEntity<List<Comida>> listarComidas(){
    	
    	List<Comida> result = this.getComidaService().listarComidas();	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }

	@ApiOperation(value = "Edita una comida pasada como parametro", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "se genero la lista de comidas satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un problema tratando de obtener la lista de comidas")
	}
	)
    @RequestMapping(path="/comidas/{idComida}", method = RequestMethod.PUT)
    public ResponseEntity<String> editarComida(@PathVariable("idComida") Long idComida,@RequestParam(value="idUsuario", required=false)Integer idUsuario, @RequestParam(value="nombre")String nombre, @RequestParam(value="cantidadCalorias")Long cantidadCalorias) throws Exception{
    	Comida comida = this.getComidaService().editarComida(idComida, idUsuario, nombre, cantidadCalorias);
    	if (comida!=null) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Comida no editada", HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "Elimina una comida del sistema", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "La comida fue eliminada satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un problema tratando de borrar la comida")
	}
	)
    @RequestMapping(path="/comidas/{idComida}", method = RequestMethod.DELETE)
    public ResponseEntity<Comida> eliminarComida(@PathVariable("idComida") long idComida){
    	if (this.getComidaService().eliminarComida(idComida)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "Agrega un ingrediente nuevo a una comida especifica", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El ingrediente fue agregado satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un problema tratando de agregar el ingrediente")
	}
	)
    @RequestMapping(path="/comidas/{idComida}/ingredientes", method = RequestMethod.POST)
    public ResponseEntity<Comida> agregarIngrediente(@PathVariable("idComida") long idComida, int idUsuario, String nombre, int cantidad, String medida){
    	Comida comida = this.getComidaService().agregarIngrediente(idUsuario, idComida, nombre, cantidad, medida);
    	if (comida.getId()!=0) {
    		return new ResponseEntity<>(comida, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "Retorna la lista de ingredientes para una comida en particular", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "La lista de ingredientes fue generada satisfactoriamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error generando la lista de ingredientes")
	}
	)
    @RequestMapping(path="/comidas/{idComida}/ingredientes", method = RequestMethod.GET)
    public ResponseEntity<List<Ingrediente>> listarIngredientes(@PathVariable("idComida") long idComida){
    	
    	List<Ingrediente> result = this.getComidaService().listarIngredientes(idComida); 
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }

	@ApiOperation(value = "Retorna la existencia o no de un ingrediente en una comida", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "True/False si el ingrediente existe o no"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de verificar la existencia del ingrediente")
	}
	)
    @RequestMapping(path="/comidas/{idComida}/ingredientes/{idIngrediente}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Ingrediente>> listarIngredientes(@PathVariable("idComida") long idComida, 
    		@PathVariable("idIngrediente") long idIngrediente){
    	
    	Optional<Ingrediente> result = this.getComidaService().obtenerIngrediente(idComida, idIngrediente); 
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
	@ApiOperation(value = "Elimina un ingrediente para una comida", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El ingrediente fue eliminado correctamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de eliminar el ingrediente")
	}
	)
    @RequestMapping(path="/comidas/{idComida}/ingredientes/{idIngrediente}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarIngrediente(@PathVariable("idComida") long idComida, 
    		@PathVariable("idIngrediente") long idIngrediente){
    	
    	if (this.getComidaService().eliminarIngrediente(idComida, idIngrediente)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Ingrediente no eliminado", HttpStatus.CONFLICT);
    	}
    }
    
	@ApiOperation(value = "Modifica un ingrediente perteneciente a una comida", response = Comida.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "El ingrediente fue modificado correctamente"),
	        @ApiResponse(code = 401, message = "No se encuentra autorizado para crear una comida"),
	        @ApiResponse(code = 403, message = "El accesso a esta prohibido"),
	        @ApiResponse(code = 409, message = "Ocurrio un error tratando de modificar el ingrediente")
	}
	)
    @RequestMapping(path="/comidas/{idComida}/ingredientes/{idIngrediente}", method = RequestMethod.PUT)
    public ResponseEntity<Comida> actualizarIngrediente(@PathVariable("idComida") long idComida, 
    		@PathVariable("idIngrediente") long idIngrediente, String nombre, int cantidad, String medida){
    	Comida comida = this.getComidaService().actualizarIngrediente(idComida, idIngrediente, nombre, cantidad, medida);
    	if (comida!=null) {
    		return new ResponseEntity<>(comida, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
        

}
