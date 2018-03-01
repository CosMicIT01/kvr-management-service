package de.cosmicit.kvr.model.repository;

import de.cosmicit.kvr.model.entities.Address;
import de.cosmicit.kvr.model.entities.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {


}
