package com.choker.claimcenter.service;

import com.choker.claimcenter.exception.PatientNotFoundException;
import com.choker.claimcenter.model.Gender;
import com.choker.claimcenter.model.Patient;
import com.choker.claimcenter.repository.PatientRepository;
import com.choker.claimcenter.dto.PatientPreview;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {

    private final PatientRepository repo;

    static Patient mapToPatient(PatientPreview patientPreview) {
        return Patient.builder().id(patientPreview.getId())
                .name(patientPreview.getName())
                .cardNumber(patientPreview.getCardNumber())
                .dob(patientPreview.getDob())
                .gender(Gender.valueOf(patientPreview.getGender())).build();
    }

    static PatientPreview mapToPatientPreview(Patient patient) {
        return PatientPreview.builder()
                .id(patient.getId())
                .name(patient.getName())
                .cardNumber(patient.getCardNumber())
                .dob(patient.getDob())
                .gender(patient.getGender().ordinal()).build();

    }

//    public PatientPreview getPatient(String cardNumber) {
//
//        PatientPreview.validateCardNumber(cardNumber);
//        var patient = repo.findByCardNumber(cardNumber);
//        return patient.map(PatientService::mapToPatientPreview).orElse(null);
//    }

    public PatientPreview getPatient(String cardNumber) {

        PatientPreview.validateCardNumber(cardNumber);

        var patient = repo.findByCardNumber(cardNumber);

        return patient.map(PatientService::mapToPatientPreview)
                .orElseThrow(() -> new PatientNotFoundException(cardNumber));
    }
}