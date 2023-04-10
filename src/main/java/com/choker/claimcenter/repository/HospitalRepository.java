package com.choker.claimcenter.repository;

import com.choker.claimcenter.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
