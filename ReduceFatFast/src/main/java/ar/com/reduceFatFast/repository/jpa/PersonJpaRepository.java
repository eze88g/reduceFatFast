package ar.com.reduceFatFast.repository.jpa;

import java.util.Date;

import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.dto.PersonDto;
import ar.com.reduceFatFast.model.Person;
import ar.com.reduceFatFast.repository.PersonRepository;

@Repository
public class PersonJpaRepository extends RFFJpaRepository<Person> implements PersonRepository {

	@Override
	public boolean addPerson(String lastname, String firstname, Date bithdate, Long weight, Long width) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonDto getPerson(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMeasure(long id, Long weight, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

//	List<Person> getAllPerson();
}
