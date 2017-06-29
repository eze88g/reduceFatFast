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
    public ResponseEntity<GrupoDto> crearGrupo(long idUsuario, String nombre){
		Grupo grupo = this.getGrupoService().crearGrupo(idUsuario, nombre); 
    	if (grupo != null) {
    		return new ResponseEntity<GrupoDto>(new GrupoDto(grupo), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<GrupoDto>(HttpStatus.CONFLICT);
    	}
    }
	
	@RequestMapping(path="/grupos", method = RequestMethod.GET)
    public ResponseEntity<List<GrupoDto>> listarGrupos(){
		
		Iterable<Grupo> result = this.getGrupoService().listarGrupos();
		
		List<GrupoDto> grupos = new ArrayList<GrupoDto>();
		for (Grupo each : result) {
			grupos.add(new GrupoDto(each));
		}
		
		return new ResponseEntity<>(grupos, HttpStatus.OK);
    }
    
    @RequestMapping(path="/grupos/{idGrupo}/miembros", method = RequestMethod.POST)
    public ResponseEntity<String> agregarPaciente(@PathVariable("idGrupo") long idGrupo, long idPaciente, long idUsuario){
    	if (this.getGrupoService().agregarMiembro(idUsuario, idGrupo, idPaciente)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Miembro no agregado al grupo", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/grupos/{idGrupo}/miembros", method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDto>> listarPacientes(@PathVariable("idGrupo") long idGrupo){
    	
    	List<Paciente> result = this.getGrupoService().listarMiembros(idGrupo);
    	
    	List<PacienteDto> pacientes = new ArrayList<>();
    	
    	for (Paciente each : result) {
    		pacientes.add(new PacienteDto(each));
    	}
    	
    	return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    
    @RequestMapping(path="/grupos/{idGrupo}/dieta", method = RequestMethod.GET)
    public ResponseEntity<DietaSemanalDto> obtenerDieta(@PathVariable("idGrupo") long idGrupo){
    	DietaSemanal dieta = this.getGrupoService().obtenerDieta(idGrupo);
    	
    	if (dieta != null) {
    		return new ResponseEntity<>(new DietaSemanalDto(dieta), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/grupos/{idGrupo}/dieta/validar", method = RequestMethod.POST)
    public ResponseEntity<String> validarDieta(@PathVariable("idGrupo") long idGrupo, long idNutricionista){
    	if (this.getGrupoService().validarDieta(idGrupo, idNutricionista)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Dieta no validada", HttpStatus.CONFLICT);
    	}
    }
}
