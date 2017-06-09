package ar.com.reduceFatFast.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.Person;
import ar.com.reduceFatFast.repository.PersonRepository;

@Repository
@Profile("test")
public class PersonJpaRepository extends RFFJpaRepository<Person> implements PersonRepository{

//	List<Person> getAllPerson();
}
