package com.choker.claimcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClaimDetail {

    private Long patientId;
    private PatientPreview patient;

    private Integer hospitalId;
    private HospitalReference  hospital;

    private Long physicianId;
    private PhysicianReference  physician;

    private LocalDateTime admissionDate;

    private String medicalCase;

    private BigDecimal estimatedCost;

    private int status;

    private String remarks;

    public void validate() {
        if (patientId == null) throw new IllegalArgumentException("A valid 'Card Number' is required");
        if (hospitalId == null) throw new IllegalArgumentException("Hospital is required");
        if (medicalCase == null || medicalCase.isEmpty())
            throw new IllegalArgumentException("'Medical Case' is required");
        if (status == 0) throw new IllegalArgumentException("Status is required");
    }
}
