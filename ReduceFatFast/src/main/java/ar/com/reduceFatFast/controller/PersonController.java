/**
 * 
 */
package ar.com.reduceFatFast.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(path="/persona/{id}/weight", method = RequestMethod.POST)
    public ResponseEntity<String> addMeasure(@PathVariable("id") long id, long weight, String date){
    	Date convertedDate = parseDateFromString(date);
    	if (convertedDate == null) {
    		return new ResponseEntity<>("Invalid date", HttpStatus.CONFLICT);
    	}
    	
    	if (this.getPersonService().addMeasure(id, weight, convertedDate)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Measure not added", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/persona", method = RequestMethod.POST)
    public ResponseEntity<String> addPerson(String lastname, String firstname, String bithdate, Long weight, Long width){
    	Date convertedDate = parseDateFromString(bithdate);
    	if (convertedDate == null) {
    		return new ResponseEntity<>("Invalid date", HttpStatus.CONFLICT);
    	}
    	
        if (this.getPersonService().addPerson(lastname, firstname, convertedDate, weight, width)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Person not added", HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(path="/persona", method = RequestMethod.GET)
    public ResponseEntity<PersonDto> getPerson(Long id){
        PersonDto result = this.getPersonService().getPerson(id);
        
        return new ResponseEntity<>(result, HttpStatus.OK);
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
	
	private Date parseDateFromString(String text) {
	    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	    Date dateObj = null;
	    try {
	        dateObj = format.parse(text);
	    } catch (Exception e) {
	        return null;
	    }

	    return dateObj;
	}
}
