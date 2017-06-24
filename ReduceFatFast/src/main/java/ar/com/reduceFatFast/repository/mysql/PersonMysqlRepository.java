package ar.com.reduceFatFast.repository.mysql;

import java.util.Date;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.dto.PersonDto;
import ar.com.reduceFatFast.model.Person;
import ar.com.reduceFatFast.repository.PersonRepository;

@Repository
@Profile({"dev","default"})
public class PersonMysqlRepository extends RFFCrudRepository<Person> implements PersonRepository {

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

}
