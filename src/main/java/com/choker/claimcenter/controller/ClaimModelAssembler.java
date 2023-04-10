package com.choker.claimcenter.controller;

import com.choker.claimcenter.dto.ClaimDetail;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class ClaimModelAssembler  implements RepresentationModelAssembler<ClaimDetail, EntityModel<ClaimDetail>> {
    @Override
    public EntityModel<ClaimDetail> toModel(ClaimDetail claim) {

        return EntityModel.of(claim,
                linkTo(methodOn(ClaimController.class).getClaims(null, null, null, null)).withRel("claims"));    }
}
