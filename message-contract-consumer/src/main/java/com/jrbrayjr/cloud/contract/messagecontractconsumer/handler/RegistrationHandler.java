package com.jrbrayjr.cloud.contract.messagecontractconsumer.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class RegistrationHandler {

    @Bean
    public Consumer<Registration> register() {
        return registration -> {
            System.out.println(registration.patientName);
        };
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Registration {
        private String patientName;
        private String primaryPhysician;
        private Boolean admitted;
        private String healthInsurer;
    }
}
