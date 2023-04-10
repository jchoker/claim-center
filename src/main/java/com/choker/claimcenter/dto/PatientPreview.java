package com.choker.claimcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PatientPreview {
    private Long id;
    private String cardNumber;
    private String name;
    private LocalDate dob;
    private int gender;

    public static void validateCardNumber(String nb) {
        if (nb == null || nb.isEmpty())
            throw new IllegalArgumentException("'Card Number' cannot be empty. Enter a valid number.");
        if (nb.trim().length() != 16)
            throw new IllegalArgumentException("Invalid 'Card Number'. Must be 16 characters");
        if (!nb.matches("^[a-zA-Z0-9]*$"))
            throw new IllegalArgumentException("Invalid 'Card Number'. Should contain alphanumeric characters only");
    }
}
