/**
 * 
 */
package ar.com.reduceFatFast.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Boolean addPerson(String lastname, String firstname, Date bithdate, Long weight, Long width) {
		return personRepository.addPerson(lastname, firstname, bithdate, weight, width);
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

	public PersonDto getPerson(Long id) {
		return this.personRepository.getPerson(id);
	}

	public boolean addMeasure(long id, Long weight, Date date) {
		return this.personRepository.addMeasure(id, weight, date);
	}
	
}
