package com.choker.claimcenter.controller;

import com.choker.claimcenter.dto.PatientPreview;
import com.choker.claimcenter.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    //http://localhost:8080/api/patients/abcdef0123456789
    @GetMapping("/{card-number}")
    @ResponseStatus(HttpStatus.OK)
//	public PatientPreview get(@PathVariable("card-number") String cardNumber) {
//		return service.getPatient(cardNumber);
//	}

    public EntityModel<PatientPreview> get(@PathVariable("card-number") String cardNumber) {

        var patient = service.getPatient(cardNumber);

        return EntityModel.of(patient,
                linkTo(methodOn(PatientController.class).get(cardNumber)).withSelfRel());
    }
}