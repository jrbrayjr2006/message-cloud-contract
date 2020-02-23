package com.jrbrayjr.cloud.contract.messagecontractproducer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jrbrayjr.cloud.contract.messagecontractproducer.event.RegistrationEventEmitter;
import com.jrbrayjr.cloud.contract.messagecontractproducer.model.Registration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RegistrationControllerTest {

    RegistrationEventEmitter mockEmitter;
    RegistrationController controller;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        mockEmitter = mock(RegistrationEventEmitter.class);
        controller = new RegistrationController(mockEmitter);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Given a request, when registration data is available, then register is triggered")
    void shouldCallRegistrationEmitter() throws Exception {
        // Given
        Registration someRegistration = new Registration();
        someRegistration.setAdmitted(true);
        someRegistration.setHealthInsurer("Acme Insurance");
        someRegistration.setPatientName("John Doe");
        someRegistration.setPrimaryPhysician("Doctor Spock");
        String endpoint = "/register";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(someRegistration);

        // When
        mockMvc.perform(post(endpoint).contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk());

        // Then
        verify(mockEmitter).handleMessage(someRegistration);
    }
}