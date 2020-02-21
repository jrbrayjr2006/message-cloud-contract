package com.jrbrayjr.cloud.contract.messagecontractproducer.event;

import com.jrbrayjr.cloud.contract.messagecontractproducer.model.Registration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Component
public class RegistrationEventEmitter {

    private EmitterProcessor<Registration> processor;

    @Bean
    public Supplier<Flux<Registration>> register() {
        Registration registration = new Registration();
        return () -> Flux.from(processor -> processor.onNext(registration));
    }
}
