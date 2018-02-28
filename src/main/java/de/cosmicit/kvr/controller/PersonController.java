package de.cosmicit.kvr.controller;


import de.cosmicit.kvr.controller.exception.InvalidParameterException;
import de.cosmicit.kvr.controller.exception.ResourceNotFoundException;
import de.cosmicit.kvr.model.entities.Person;
import de.cosmicit.kvr.model.repository.PersonRepository;
import de.cosmicit.kvr.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController extends AbstractRestController<Person> {

    public static final String REGISTRATION_URL = "/person/registration";

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return super.get(id);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Person> getList() {
        List<Person> persons = super.getList();
        return persons;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Person create(@RequestBody Person entity) throws InvalidParameterException {
        return super.create(entity);
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Person replace(@PathVariable("id") Long id, @RequestBody String jsonData)
            throws ResourceNotFoundException, InvalidParameterException, IOException {
        return super.replace(id, jsonData);
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public Person update(@PathVariable("id") Long id, @RequestBody String jsonData)
            throws ResourceNotFoundException, InvalidParameterException, IOException {
        return super.update(id, jsonData);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        super.delete(id);
    }

}
