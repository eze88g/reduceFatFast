package ar.com.reduceFatFast.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.Person;

@Repository
public interface PersonJpaRepository extends CrudRepository<Person,Long>{

//	List<Person> getAllPerson();
}
