package de.cosmicit.kvr.service;

import de.cosmicit.kvr.model.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

}
