package com.jrbrayjr.cloud.contract.messagecontractproducer.controller;

import com.jrbrayjr.cloud.contract.messagecontractproducer.event.RegistrationEventEmitter;
import com.jrbrayjr.cloud.contract.messagecontractproducer.model.Registration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private RegistrationEventEmitter registrationEventEmitter;

    public RegistrationController(RegistrationEventEmitter registrationEventEmitter) {
        this.registrationEventEmitter = registrationEventEmitter;
    }

    @PostMapping( value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> registerPatient(@RequestBody Registration registration) {
        registrationEventEmitter.register();
        return ResponseEntity.ok().build();
    }

}
