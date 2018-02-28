package de.cosmicit.kvr.model.repository;

import de.cosmicit.kvr.model.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {


}
