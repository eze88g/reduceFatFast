package ar.com.reduceFatFast.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.Person;
import ar.com.reduceFatFast.repository.PersonRepository;

@Repository
@Profile("test")
public interface PersonJpaRepository extends PersonRepository, JpaRepository<Person, Long> {

//	List<Person> getAllPerson();
}
