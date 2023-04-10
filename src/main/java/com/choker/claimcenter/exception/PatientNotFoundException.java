package com.choker.claimcenter.exception;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String cardNumber) {
        super("Could not find patient " + cardNumber);
    }
}
