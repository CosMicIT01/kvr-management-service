package de.cosmicit.kvr.controller;


import de.cosmicit.kvr.controller.exception.InvalidParameterException;
import de.cosmicit.kvr.controller.exception.ResourceNotFoundException;
import de.cosmicit.kvr.model.entities.Registration;
import de.cosmicit.kvr.model.repository.RegistrationRepository;
import de.cosmicit.kvr.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationController extends AbstractRestController<Registration> {

    public static final String SUBSCRIPTION_URL = "/registration/subscription";

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    RegistrationService registrationService;

    @Override
    public Class<Registration> getEntityClass() {
        return Registration.class;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Registration get(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return super.get(id);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Registration> getList() {
        List<Registration> registrations = super.getList();
        return registrations;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Registration create(@RequestBody Registration entity) throws InvalidParameterException {
        return super.create(entity);
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Registration replace(@PathVariable("id") Long id, @RequestBody String jsonData)
            throws ResourceNotFoundException, InvalidParameterException, IOException {
        return super.replace(id, jsonData);
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public Registration update(@PathVariable("id") Long id, @RequestBody String jsonData)
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
