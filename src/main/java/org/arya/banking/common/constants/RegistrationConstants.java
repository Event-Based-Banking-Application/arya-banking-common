package org.arya.banking.common.constants;

import lombok.Getter;

@Getter
public enum RegistrationConstants {

    BASIC_DETAILS_ADDED( "REGISTRATION_IN_PROGRESS",  "BASIC_DETAILS_ADDITION_COMPLETED", "ADD_SECURITY_DETAILS",  "BASIC_DETAILS_ADDED"),
    SECURITY_CREDENTIALS_ADDED("REGISTRATION_IN_PROGRESS", "SECURITY_CREDENTIALS_ADDED", "ADD_ADDRESS", "SECURITY_CREDENTIALS_ADDED"),
    ADD_ADDRESS("ADDRESS_ADDED", "REGISTRATION_COMPLETE", "", "ADD_ADDRESS");

    private final String status;
    private final String subStatus;
    private final String nextStep;
    private final String lastStepCompleted;

    RegistrationConstants(String status, String subStatus, String nextStep, String lastStepCompleted) {
        this.status = status;
        this.subStatus = subStatus;
        this.nextStep = nextStep;
        this.lastStepCompleted = lastStepCompleted;
    }

}
