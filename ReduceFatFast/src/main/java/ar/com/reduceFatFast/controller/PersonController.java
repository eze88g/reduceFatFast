/**
 * 
 */
package ar.com.reduceFatFast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.dto.PersonDto;
import ar.com.reduceFatFast.service.PersonService;

/**
 * @author joaco
 *
 */
@Validated
@RestController
public class PersonController {
	
    @Autowired
    private PersonService personService;
 
    @RequestMapping("/")
    public String index(){
        return "Welcome to the Jungle";
    }
    
    @RequestMapping("/addWeights")
    public Boolean addWeights(PersonDto person){
        return null ; //this.getPersonService().addMeasures(person.getId(), person.getMeasures());;
    }
    
    @RequestMapping(path="/addPerson", method = RequestMethod.POST)
    public Boolean addPerson(PersonDto person){
        return this.getPersonService().addPerson(person);
    }
    
    // Setters and Getters

	/**
	 * @return the personService
	 */
	public PersonService getPersonService() {
		return personService;
	}

	/**
	 * @param personService the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
}
