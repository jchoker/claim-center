package com.choker.claimcenter;

import com.choker.claimcenter.repository.ClaimRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.choker.claimcenter.dto.ClaimDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClaimCenterApplicationTests {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ClaimRepository claimRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldCreateClaim() throws Exception {
        var count = claimRepository.findAll().size();
        ClaimDetail request = getClaimDetail();

        String requestString = objectMapper.writeValueAsString(request);

        mvc.perform(MockMvcRequestBuilders.post("/api/claims").contentType(MediaType.APPLICATION_JSON)
                .content(requestString)).andExpect(status().isCreated());

        Assertions.assertEquals(count + 1, claimRepository.findAll().size());
    }

    private ClaimDetail getClaimDetail() {

        return ClaimDetail.builder()
                .patientId((long) 1)
                .hospitalId(1)
                .physicianId((long) 1)
                .medicalCase("Case XYZ")
                .status(2)
                .admissionDate(LocalDateTime.now())
                .estimatedCost(new BigDecimal(15.75))
                .remarks("remark 01").build();
    }
}
