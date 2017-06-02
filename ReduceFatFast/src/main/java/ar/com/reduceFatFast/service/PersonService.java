/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.dto.PersonDto;
import ar.com.reduceFatFast.exception.FatFastException;
import ar.com.reduceFatFast.model.Measure;
import ar.com.reduceFatFast.model.Person;
import ar.com.reduceFatFast.repository.PersonRepository;

/**
 * @author joaco
 *
 */
@Service
@Configuration
@ImportResource("classpath:config.xml")
@Profile({"development"})
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Boolean addPerson(PersonDto person) {
		return null;
	}
	
	public void delMeasure(Person person, Measure measure){
		
	}
	
	public void editMeasure(Person person, Measure measure){
		
	}
	
	public Person getPersonInfo(Person person, Date from, Date to){
		return null;
	}
	
	public List<Person> getAllPerson() throws FatFastException{
		try{
			return null; //personRepository.getAllPerson();
		}catch(Exception e){
			throw new FatFastException(e);
		}
	}

	public Boolean addMeasures(Person person) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// setters and getters

	/**
	 * @return the personRepository
	 */
	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	/**
	 * @param personRepository the personRepository to set
	 */
	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
}
