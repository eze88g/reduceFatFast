/**
 * 
 */
package ar.com.reduceFatFast.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.dto.PersonDto;

/**
 * @author joaco
 *
 */
@Repository
public interface PersonRepository{

	boolean addPerson(String lastname, String firstname, Date bithdate, Long weight, Long width);

	PersonDto getPerson(Long id);

	boolean addMeasure(long id, Long weight, Date date);
}
