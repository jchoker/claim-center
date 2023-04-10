package com.choker.claimcenter.controller;

import com.choker.claimcenter.dto.PhysicianReference;
import com.choker.claimcenter.service.PhysicianService;
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
@RequestMapping("/api/physicians")
@RequiredArgsConstructor
public class PhysicianController {

    private final PhysicianService service;

    //http://localhost:8080/api/physicians
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
//	public List<PhysicianReference> getAll(){
//		return service.getAllPhysicians();
//	}

    public CollectionModel<EntityModel<PhysicianReference>> getAll() {

        List<EntityModel<PhysicianReference>> physicians = service.getAllPhysicians().stream()
                .map(p -> EntityModel.of(p,
                        linkTo(methodOn(PhysicianController.class).getAll()).withRel("physicians")))
                .collect(Collectors.toList());

        return CollectionModel.of(physicians, linkTo(methodOn(PhysicianController.class).getAll()).withSelfRel());
    }
}
