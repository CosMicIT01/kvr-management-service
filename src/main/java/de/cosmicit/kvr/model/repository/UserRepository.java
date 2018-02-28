package de.cosmicit.kvr.model.repository;

import de.cosmicit.kvr.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
