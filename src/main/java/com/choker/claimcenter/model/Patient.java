package com.choker.claimcenter.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Size(min = 16, max = 16)
    @Column(unique = true, nullable = false)
    private String cardNumber;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private Gender gender;
}
