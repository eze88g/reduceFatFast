/**
 * 
 */
package ar.com.reduceFatFast.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.model.Comida;
import ar.com.reduceFatFast.model.Comida.ComidaDelDia;
import ar.com.reduceFatFast.model.Dia;
import ar.com.reduceFatFast.model.DietaSemanal;
import ar.com.reduceFatFast.model.Grupo;
import ar.com.reduceFatFast.model.Ingrediente;
import ar.com.reduceFatFast.model.Nutricionista;
import ar.com.reduceFatFast.model.Paciente;
import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.service.TestService;

/**
 * @author joaco
 *
 */
@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService service;
	
	@RequestMapping("/crearComida")
	public Comida crearComida(){
		Comida comida = new Comida("Pizza Explosiva");
		comida.agregarIngrediente("Queso", 500, "gr");
		comida.agregarIngrediente("Papas Fritas", 100, "gr");
		comida.agregarIngrediente("Huevos", 2, "huevos fritos");
		comida.agregarIngrediente("Fiambre", 100, "gr");
		this.getService().add(comida);

		return comida;
	}
	@RequestMapping("/crearPollo")
	public Comida crearPollo(){
		Comida comida = new Comida("pollo");
		this.getService().add(comida);

		return comida;
	}
	
	@RequestMapping("/getComidas")
	public List<Comida> getComidas(){
		List<Comida> comidas = this.getService().getAllComidas();
		for (Comida comida : comidas) {
			logger.info("Comida: " + comida.getNombre());
			Hibernate.initialize(comida.getIngredientes());
			for (Ingrediente ingrediente : comida.getIngredientes()) {
				Hibernate.initialize(ingrediente);
				logger.info("Ingredientes: " + ingrediente.getName());
			}
		}
		return comidas;
	}
	
	@RequestMapping("/crearDia")
	public Dia crearDia(){
		Dia dia = new Dia();
		List<Comida> comidas = this.getComidas();
		dia.getComidas().put(0, comidas.get(0));
		dia.getComidas().put(1, comidas.get(0));
		dia.getComidas().put(2, comidas.get(0));
		dia.getComidas().put(3, comidas.get(0));
		
		this.getService().add(dia);
		
		return dia;
	}
	
	@RequestMapping("/getDias")
	public Map<Integer,Dia> getAllDias(){
		return (Map<Integer,Dia>) this.getService().getAllDias();
	}
	
	@RequestMapping("/addDieta")
	public DietaSemanal addDieta(){
		DietaSemanal dieta = new DietaSemanal();
		List<Comida> comidas = this.getComidas();
		Map<Integer,Dia> dias = new HashMap<Integer,Dia>();
		Dia dia;
		for (int i=0; i<7; i++) {
			dia = new Dia();
			dia.setCantidadComidasPorDia(4);	
			dia.setComida(ComidaDelDia.ALMUERZO, comidas.get(0));
			dia.setComida(ComidaDelDia.CENA, comidas.get(1));
			dias.put(i,dia);
		}
		dieta.agregarDias(dias);
		this.getService().add(dieta);
		return dieta;
	}
	
	@RequestMapping("/getDietas")
	public List<DietaSemanal> getDietas(){
		return this.getService().getDietas();
	}
	
	@RequestMapping("/crearGrupo")
	public Grupo crearGrupo(){
		// lo basico para crear el grupo, reutilizo los anteriores controllers
		this.crearComida();
		this.addDieta();
		this.crearNutricionista();
		Nutricionista nutricionista = this.getService().getNutricionistas().get(0);
		Grupo grupo = new Grupo(nutricionista,"Gordos Anonimos");
		grupo.setNutricionista(nutricionista);
		DietaSemanal dieta = this.getDietas().get(0);
		grupo.setDietaSemanal(dieta);
		this.getService().add(grupo);
		return grupo;
	}
	
	
	
	@RequestMapping("/agregarPaciente")
	public Grupo crearPaciente(){
		Paciente paciente = new Paciente("Sancho Panza", 11111111, null);
		Nutricionista nutricionista = this.getService().getNutricionistas().get(0);
		nutricionista.getGrupos().get(0).agregarPaciente(paciente);
		this.getService().add(nutricionista.getGrupos().get(0));
		
		return nutricionista.getGrupos().get(0);
	}
	
	@RequestMapping("/getGrupos")
	public List<Grupo> getGrupos(){
		List<Grupo> grupos = this.getService().getGrupos();
		logger.debug(grupos.get(0).getDietaSemanal().toString());
		logger.debug(grupos.get(0).getDietaSemanal().getDias().toString());	
		return grupos;
	}
	
	@RequestMapping("/crearNutricionista")
	public Nutricionista crearNutricionista(){
		Nutricionista nutricionista = new Nutricionista("Lavar Ball", 33333333,null);
		this.getService().add(nutricionista);
		return nutricionista;
		
	}
	
	@RequestMapping("/getNutricionistas")
	public List<Nutricionista> getNutricionista(){
		return this.getService().getNutricionistas();
		
	}
	
	@RequestMapping("/actualizarSistema")
	public Sistema actualizarSistema(){
		return this.getService().actualizarSistema();
	}
	
	@RequestMapping("/prueba")
	public Boolean prueba(){
		return this.getService().prueba();
	}

	/**
	 * @return the service
	 */
	public TestService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(TestService service) {
		this.service = service;
	}

}
