package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAllByDateInGreaterThanEqualAndDateOutLessThanEqual(LocalDate dateIn, LocalDate dateOut); //between trzeba dodać!

    //findAllByDateInLessThanEqualAndDateOutGreaterThanEqual
}
