package de.cosmicit.kvr.service;

import de.cosmicit.kvr.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

}
