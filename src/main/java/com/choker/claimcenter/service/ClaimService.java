package com.choker.claimcenter.service;

import com.choker.claimcenter.model.*;
import com.choker.claimcenter.repository.ClaimRepository;
import com.choker.claimcenter.dto.ClaimDetail;
import com.choker.claimcenter.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.choker.claimcenter.service.Utils.parseDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClaimService {

    private final ClaimRepository repo;

    public ClaimDetail createClaim(ClaimDetail detail) {

        detail.validate();

        Claim claim = mapToClaim(detail);
        repo.save(claim);
        log.info("Claim {} is saved", claim.getId());
        repo.refresh(claim); // call refresh on entity to retrieve latest from db
        return mapToClaimDetail(claim);
    }

    private Claim mapToClaim(ClaimDetail detail) {

        var patient = Patient.builder().id(detail.getPatientId()).build();
        var hospital = Hospital.builder().id(detail.getHospitalId()).build();
        var physician = (detail.getPhysicianId() == null) ? null : Physician.builder().id(detail.getPhysicianId()).build();

        var claim = Claim.builder()
                .patient(patient)
                .hospital(hospital)
                .physician(physician)
                .admissionDate(detail.getAdmissionDate())
                .medicalCase(detail.getMedicalCase())
                .estimatedCost(detail.getEstimatedCost())
                .status(ClaimStatus.valueOf(detail.getStatus()))
                .remarks(detail.getRemarks()).build();

        return claim;
    }

    public List<ClaimDetail> getClaimsByCustomCriteria(
            String admittedFrom,
            String admittedTill,
            Integer hospitalId,
            String cardNumber) {

        var claims = repo.getClaimsByCustomCriteria(parseDate(admittedFrom), parseDate(admittedTill), hospitalId, cardNumber);
        return claims.stream().map(this::mapToClaimDetail).toList();
    }

    private ClaimDetail mapToClaimDetail(Claim claim) {
        var phy = claim.getPhysician();
        return ClaimDetail.builder()
                .patientId(claim.getPatient().getId())
                .patient(PatientService.mapToPatientPreview(claim.getPatient()))
                .hospitalId(claim.getHospital().getId())
                .hospital(HospitalService.mapToHospitalReference(claim.getHospital()))
                .physicianId(phy == null ? null : phy.getId())
                .physician(PhysicianService.mapToPhysicianReference(phy))
                .medicalCase(claim.getMedicalCase())
                .status(claim.getStatus().ordinal())
                .admissionDate(claim.getAdmissionDate())
                .estimatedCost(claim.getEstimatedCost())
                .remarks(claim.getRemarks()).build();
    }
}
