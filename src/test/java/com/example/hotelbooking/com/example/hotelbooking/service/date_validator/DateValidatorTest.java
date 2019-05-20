package com.example.hotelbooking.service.date_validator;

import org.junit.Test;

import java.time.LocalDate;

import static com.example.hotelbooking.service.date_validator.DateValidator.validateDate;

public class DateValidatorTest {

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenDateInIsAfterDateOut() {

        LocalDate localDate1 = LocalDate.of(2019, 05, 13);
        LocalDate localDate2 = LocalDate.of(2019, 05, 15);

        validateDate(localDate2, localDate1);
    }
}