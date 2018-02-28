package de.cosmicit.kvr.controller;


import de.cosmicit.kvr.controller.exception.InvalidParameterException;
import de.cosmicit.kvr.controller.exception.ResourceNotFoundException;
import de.cosmicit.kvr.model.entities.Address;
import de.cosmicit.kvr.model.repository.AddressRepository;
import de.cosmicit.kvr.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/address")
public class AddressController extends AbstractRestController<Address> {

    public static final String REGISTRATION_URL = "/address/registration";

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressService addressService;

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Address get(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return super.get(id);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Address> getList() {
        List<Address> addresss = super.getList();
        return addresss;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Address create(@RequestBody Address entity) throws InvalidParameterException {
        return super.create(entity);
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Address replace(@PathVariable("id") Long id, @RequestBody String jsonData)
            throws ResourceNotFoundException, InvalidParameterException, IOException {
        return super.replace(id, jsonData);
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public Address update(@PathVariable("id") Long id, @RequestBody String jsonData)
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
