package com.choker.claimcenter.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Utils {

    static LocalDateTime parseDate(String date) {
        if (date == null) return  null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter).atStartOfDay();
    }
}
