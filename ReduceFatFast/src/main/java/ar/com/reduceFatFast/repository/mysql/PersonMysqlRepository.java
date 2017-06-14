package ar.com.reduceFatFast.repository.mysql;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.Person;
import ar.com.reduceFatFast.repository.PersonRepository;

@Repository
@Profile({"dev","default"})
public class PersonMysqlRepository extends RFFCrudRepository<Person> implements PersonRepository {

}
