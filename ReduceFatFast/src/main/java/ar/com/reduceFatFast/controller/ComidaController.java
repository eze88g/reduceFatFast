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

import ar.com.reduceFatFast.dto.ComidaDto;
import ar.com.reduceFatFast.dto.IngredienteDto;
import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Ingrediente;
import ar.com.reduceFatFast.service.ComidaService;

/**
 * @author Matias
 *
 */
@Validated
@RestController
public class ComidaController extends AbstractController{
	
    @Autowired
    private ComidaService comidaService;
    
    public ComidaService getComidaService() {
		return comidaService;
	}

	public void setComidaService(ComidaService comidaService) {
		this.comidaService = comidaService;
	}
 
    @RequestMapping(path="/comidas", method = RequestMethod.POST)
    public ResponseEntity<Comida> crearComida(int idUsuario, String nombre, long cantidadCalorias){
    	Comida comida = this.getComidaService().crearComida(idUsuario, nombre, cantidadCalorias);
    	if (comida.getId()!=0) {
    		ResponseEntity response = new ResponseEntity<>(comida, HttpStatus.OK);
    		return response;
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/comidas", method = RequestMethod.GET)
    public ResponseEntity<List<Comida>> listarComidas(){
    	
    	List<Comida> result = this.getComidaService().listarComidas();	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path="/comidas/{idComida}", method = RequestMethod.PUT)
    public ResponseEntity<String> editarComida(@PathVariable("idComida") Long idComida,@RequestParam(value="idUsuario", required=false)Integer idUsuario, @RequestParam(value="nombre")String nombre, @RequestParam(value="cantidadCalorias")Long cantidadCalorias){
    	Comida comida = this.getComidaService().editarComida(idComida, idUsuario, nombre, cantidadCalorias);
    	if (comida!=null) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Comida no editada", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/comidas/{idComida}", method = RequestMethod.DELETE)
    public ResponseEntity<Comida> eliminarComida(@PathVariable("idComida") long idComida){
    	if (this.getComidaService().eliminarComida(idComida)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/comidas/{idComida}/ingredientes", method = RequestMethod.POST)
    public ResponseEntity<Comida> agregarIngrediente(@PathVariable("idComida") long idComida, int idUsuario, String nombre, int cantidad, String medida){
    	Comida comida = this.getComidaService().agregarIngrediente(idUsuario, idComida, nombre, cantidad, medida);
    	if (comida.getId()!=0) {
    		return new ResponseEntity<>(comida, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/comidas/{idComida}/ingredientes", method = RequestMethod.GET)
    public ResponseEntity<List<Ingrediente>> listarIngredientes(@PathVariable("idComida") long idComida){
    	
    	List<Ingrediente> result = this.getComidaService().listarIngredientes(idComida); 
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(path="/comidas/{idComida}/ingredientes/{idIngrediente}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Ingrediente>> listarIngredientes(@PathVariable("idComida") long idComida, 
    		@PathVariable("idIngrediente") long idIngrediente){
    	
    	Optional<Ingrediente> result = this.getComidaService().obtenerIngrediente(idComida, idIngrediente); 
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(path="/comidas/{idComida}/ingredientes/{idIngrediente}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarIngrediente(@PathVariable("idComida") long idComida, 
    		@PathVariable("idIngrediente") long idIngrediente){
    	
    	if (this.getComidaService().eliminarIngrediente(idComida, idIngrediente)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Ingrediente no eliminado", HttpStatus.CONFLICT);
    	}
    }
    
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
