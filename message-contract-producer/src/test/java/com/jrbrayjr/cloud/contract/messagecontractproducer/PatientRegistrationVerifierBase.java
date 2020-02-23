package com.jrbrayjr.cloud.contract.messagecontractproducer;

import com.jrbrayjr.cloud.contract.messagecontractproducer.event.RegistrationEventEmitter;
import com.jrbrayjr.cloud.contract.messagecontractproducer.model.Registration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

import javax.inject.Inject;
import java.util.function.Supplier;

//@AutoConfigureMessageVerifier
@SpringBootTest( classes = MessageContractProducerApplication.class )
@ExtendWith(SpringExtension.class)
public abstract class PatientRegistrationVerifierBase {

    @MockBean
    private RegistrationEventEmitter eventEmitter;

//    @Inject
//    MessageVerifier<Registration> messageVerifier;

    @MockBean
    private Supplier<Flux<Registration>> mockSupplier;

    @BeforeEach
    void setUp() {}

    public void patientRegistrationTriggered() {}
}
