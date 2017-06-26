/**
 * 
 */
package ar.com.reduceFatFast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.service.ComidaService;

/**
 * @author Matias
 *
 */
@Validated
@RestController
public class ComidaController {
	
    @Autowired
    private ComidaService comidaService;
    
    public ComidaService getComidaService() {
		return comidaService;
	}

	public void setComidaService(ComidaService comidaService) {
		this.comidaService = comidaService;
	}
 
    @RequestMapping(path="/comidas", method = RequestMethod.POST)
    public ResponseEntity<String> crearComida(int idUsuario, String nombre){
    	if (this.getComidaService().crearComida(idUsuario, nombre)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Comida no creada", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/comidas/{idComida}/ingredientes", method = RequestMethod.POST)
    public ResponseEntity<String> agregarIngrediente(@PathVariable("idComida") long idComida, int idUsuario, String nombre, int cantidad, String medida){
    	if (this.getComidaService().agregarIngrediente(idUsuario, idComida, nombre, cantidad, medida)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Ingrediente no agregado", HttpStatus.CONFLICT);
    	}
    }
        

}
