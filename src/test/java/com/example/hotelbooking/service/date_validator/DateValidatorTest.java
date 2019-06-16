package com.example.hotelbooking.service.date_validator;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.example.hotelbooking.service.date_validator.DateValidator.validateDate;
@SpringBootTest
public class DateValidatorTest {

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_dateIn_is_after_dateOut() {

        LocalDate localDate1 = LocalDate.of(2019, 5, 13);
        LocalDate localDate2 = LocalDate.of(2019, 5, 15);

        validateDate(localDate2, localDate1);
    }

}