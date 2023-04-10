package com.choker.claimcenter.repository;

import com.choker.claimcenter.model.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository extends JpaRepository<Physician, Long> {
}
