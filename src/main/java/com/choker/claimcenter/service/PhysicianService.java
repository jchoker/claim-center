package com.choker.claimcenter.service;

import com.choker.claimcenter.model.Physician;
import com.choker.claimcenter.repository.PhysicianRepository;
import com.choker.claimcenter.dto.PhysicianReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PhysicianService {

    private final PhysicianRepository repo;

    public List<PhysicianReference> getAllPhysicians() {
        var physicians = repo.findAll();
        return physicians.stream().map(p -> mapToPhysicianReference(p)).toList();
    }

    static PhysicianReference mapToPhysicianReference(Physician physician) {
        if(physician == null) return  null;
        return PhysicianReference.builder()
                .id(physician.getId())
                .name(physician.getName())
                .build();
    }
}
