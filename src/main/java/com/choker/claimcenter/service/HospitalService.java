package com.choker.claimcenter.service;

import com.choker.claimcenter.model.Hospital;
import com.choker.claimcenter.repository.HospitalRepository;
import com.choker.claimcenter.dto.HospitalReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HospitalService {

    private final HospitalRepository repo;

    static HospitalReference mapToHospitalReference(Hospital hospital) {
        return HospitalReference.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .build();
    }

    public List<HospitalReference> getAllHospitals() {
        var hospitals = repo.findAll();
        return hospitals.stream().map(h -> mapToHospitalReference(h)).toList();
    }
}
