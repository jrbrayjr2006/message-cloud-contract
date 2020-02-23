package com.jrbrayjr.cloud.contract.messagecontractproducer.event;

import com.jrbrayjr.cloud.contract.messagecontractproducer.model.Registration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.Message;
import reactor.core.publisher.EmitterProcessor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RegistrationEventEmitterTest {

    EmitterProcessor<Message<Registration>> emitterProcessor;

    RegistrationEventEmitter registrationEventEmitter;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("")
    void shouldEmitRegistrationMessage() {
        // Given
        Registration registration = new Registration();

        // When

        // Then
    }
}