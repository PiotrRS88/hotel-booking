package com.example.hotelbooking.service.date_validator;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.entities.Room;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.hotelbooking.service.date_validator.DateValidator.validateDate;

public class DateValidatorTest {

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_dateIn_is_after_dateOut() {

        LocalDate localDate1 = LocalDate.of(2019, 05, 13);
        LocalDate localDate2 = LocalDate.of(2019, 05, 15);

        validateDate(localDate2, localDate1);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_reservation_has_been_made_in_given_period_of_time() {
        List<Reservation> list = new ArrayList<>();

        Reservation reservation = new Reservation();
        Room room = new Room();
        LocalDate localDate1 = LocalDate.of(2019, 05, 13);
        LocalDate localDate2 = LocalDate.of(2019, 05, 15);

        reservation.setId(1L);
        reservation.setDateIn(localDate1);
        reservation.setDateOut(localDate2);
        reservation.setRoom(room);
        room.setNumber(1);

        list.add(reservation);
        list.add(reservation);

        System.out.println(list);

        list.isEmpty();
    }
}