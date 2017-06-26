/**
 * 
 */
package ar.com.reduceFatFast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.dto.DietaSemanalDto;
import ar.com.reduceFatFast.service.GrupoService;

/**
 * @author Matias
 *
 */
@Validated
@RestController
public class GrupoController {
	
    @Autowired
    private GrupoService grupoService;
 
    public GrupoService getGrupoService() {
		return grupoService;
	}

	public void setGrupoService(GrupoService grupoService) {
		this.grupoService = grupoService;
	}

	@RequestMapping(path="/grupos", method = RequestMethod.POST)
    public ResponseEntity<String> crearGrupo(long idUsuario, String nombre){
    	if (this.getGrupoService().crearGrupo(idUsuario, nombre)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Grupo no creado", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/grupos/{idGrupo}/miembros", method = RequestMethod.POST)
    public ResponseEntity<String> agregarPaciente(long idUsuario, long idGrupo, long idPaciente){
    	if (this.getGrupoService().agregarMiembro(idUsuario, idGrupo, idPaciente)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Miembro no agregado al grupo", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/grupos/{idGrupo}/dieta", method = RequestMethod.GET)
    public ResponseEntity<DietaSemanalDto> obtenerDieta(long idGrupo){
    	DietaSemanalDto dieta = this.getGrupoService().obtenerDieta(idGrupo);
    	
    	if (dieta != null) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
}
