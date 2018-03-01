package de.cosmicit.kvr.service;

import de.cosmicit.kvr.model.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registrationService")
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    
}
