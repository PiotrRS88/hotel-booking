package com.example.hotelbooking.service.date_validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidator {
    public static void validateDate(LocalDate in, LocalDate out) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateTimeFormatter.format(in);
        dateTimeFormatter.format(out);

        if (in.isAfter(out)) throw new RuntimeException("DateIn can't be after dateOut!") {
        };
    }
}
