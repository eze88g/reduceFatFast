/**
 * 
 */
package ar.com.reduceFatFast.controller;

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
import ar.com.reduceFatFast.service.UsuarioService;

/**
 * @author Matias
 *
 */
@Validated
@RestController
public class UsuarioController {
	
    @Autowired
    private UsuarioService usuarioService;
    
    public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
 
    @RequestMapping(path="/nutricionistas", method = RequestMethod.POST)
    public ResponseEntity<String> crearNutricionista(String nombre, int dni){
    	if (this.getUsuarioService().crearNutricionista(nombre, dni)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Nutricionista no agregado", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/nutricionistas", method = RequestMethod.GET)
    public ResponseEntity<List<NutricionistaDto>> listarNutricionistas(){
    	
    	List<NutricionistaDto> result = this.getUsuarioService().listarNutricionistas(); 
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(path="/pacientes", method = RequestMethod.POST)
    public ResponseEntity<String> crearPaciente(String nombre, int dni){
    	if (this.getUsuarioService().crearPaciente(nombre, dni)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Nutricionista no agregado", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/pacientes", method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDto>> listarPacientes(){
    	
    	List<PacienteDto> result = this.getUsuarioService().listarPacientes(); 
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    

}
