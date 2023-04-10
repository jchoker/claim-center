package com.choker.claimcenter.controller;

import com.choker.claimcenter.dto.ClaimDetail;
import com.choker.claimcenter.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/claims")
@RequiredArgsConstructor
public class ClaimController {

    private final ClaimService service;

    private final ClaimModelAssembler assembler;

    /*{
    "patient_id" : 1,
    "hospital_id" : 1,
    "physician_id" : 1,
    "admission_date" : "2023-03-20 21:02:55",
    "medical_case" : "Case XYZ",
    "estimated_cost" : 15.75,
    "status" : 3,
    "remarks" : "remark 01"
}*/
    // http://localhost:8080/api/claims
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<ClaimDetail> createClaim(@RequestBody ClaimDetail claimDetail) {

        var claim = service.createClaim(claimDetail);
        return assembler.toModel(claim);
    }

// http://localhost:8080/api/claims
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ClaimDetail createClaim(@RequestBody ClaimDetail claimDetail) {
//        return service.createClaim(claimDetail);
//    }

    // http://localhost:8080/api/claims?admitted-from=2020-10-31&admitted-till=2040-10-31&card-number=abc&hospital-id=1
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<EntityModel<ClaimDetail>> getClaims(@RequestParam(value = "admitted-from", required = false) String admittedFrom,
                                                               @RequestParam(value = "admitted-till", required = false) String admittedTill,
                                                               @RequestParam(value = "card-number", required = false) String cardNumber,
                                                               @RequestParam(value = "hospital-id", required = false) Integer hospitalId) {

        List<EntityModel<ClaimDetail>> claims = service.getClaimsByCustomCriteria(admittedFrom, admittedTill, hospitalId, cardNumber).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(claims, linkTo(methodOn(ClaimController.class).getClaims(admittedFrom, admittedTill, cardNumber, hospitalId)).withSelfRel());
    }

// http://localhost:8080/api/claims?admitted-from=2020-10-31&admitted-till=2040-10-31&card-number=abc&hospital-id=1
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<ClaimDetail> getClaims(@RequestParam(value = "admitted-from", required = false) String admittedFrom,
//                                       @RequestParam(value = "admitted-till", required = false) String admittedTill,
//                                       @RequestParam(value = "card-number", required = false) String cardNumber,
//                                       @RequestParam(value = "hospital-id", required = false) Integer hospitalId) {
//
//        return service.getClaimsByCustomCriteria(admittedFrom, admittedTill, hospitalId, cardNumber);
//    }
}
