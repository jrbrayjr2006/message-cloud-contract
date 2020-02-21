package com.jrbrayjr.cloud.contract.messagecontractproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonComponent
public class Registration {

    private String patientName;
    private String primaryPhysician;
    private Boolean admitted;
    private String healthInsurer;
}
