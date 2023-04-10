package com.choker.claimcenter.repository;

import com.choker.claimcenter.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByCardNumber(String cardNumber);
}
