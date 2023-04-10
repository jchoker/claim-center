package com.choker.claimcenter.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "claim",indexes = @Index(name = "ix_admission_date", columnList = "admissionDate"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @JoinColumn(nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Hospital hospital;

    @JoinColumn(nullable = true)
    @OneToOne(fetch = FetchType.LAZY)
    private Physician physician;

    @Column(nullable = true)
    private LocalDateTime admissionDate;

    @Column(length = 200, nullable = false)
    private String medicalCase;

    @Column(precision = 14, scale = 2, nullable = true)
    private BigDecimal estimatedCost;

    @Column(nullable = false)
    private ClaimStatus status;

    @Column(length = 255, nullable = true)
    private String remarks;
}
