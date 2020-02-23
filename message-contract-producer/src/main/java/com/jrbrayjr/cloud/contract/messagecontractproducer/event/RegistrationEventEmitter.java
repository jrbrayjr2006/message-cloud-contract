package com.jrbrayjr.cloud.contract.messagecontractproducer.event;

import com.jrbrayjr.cloud.contract.messagecontractproducer.model.Registration;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Component
public class RegistrationEventEmitter {

    private EmitterProcessor<Message<Registration>> processor;

    public RegistrationEventEmitter(EmitterProcessor<Message<Registration>> processor) {
        this.processor = processor;
    }

    public void handleMessage(Registration registration) {
        Message<Registration> message = MessageBuilder.withPayload(registration).build();
        processor.onNext(message);
    }

    @Bean
    public Supplier<Flux<Message<Registration>>> register() {
        return () -> processor;
    }

}
