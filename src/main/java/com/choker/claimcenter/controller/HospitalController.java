package com.choker.claimcenter.controller;

import com.choker.claimcenter.service.HospitalService;
import com.choker.claimcenter.dto.HospitalReference;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService service;

    //http://localhost:8080/api/hospitals
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
//	public List<HospitalReference> getAll(){
//		return service.getAllHospitals();
//	}

    public CollectionModel<EntityModel<HospitalReference>> getAll() {

        List<EntityModel<HospitalReference>> hospitals = service.getAllHospitals().stream()
                .map(h -> EntityModel.of(h,
                        linkTo(methodOn(HospitalController.class).getAll()).withRel("hospitals")))
                .collect(Collectors.toList());

        return CollectionModel.of(hospitals, linkTo(methodOn(HospitalController.class).getAll()).withSelfRel());
    }


}
