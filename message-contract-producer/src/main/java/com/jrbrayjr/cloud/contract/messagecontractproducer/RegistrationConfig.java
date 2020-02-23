package com.jrbrayjr.cloud.contract.messagecontractproducer;

import com.jrbrayjr.cloud.contract.messagecontractproducer.model.Registration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.EmitterProcessor;

@Configuration
public class RegistrationConfig {

    @Bean
    public EmitterProcessor<Message<Registration>> processor() {
        return EmitterProcessor.create();
    }
}
