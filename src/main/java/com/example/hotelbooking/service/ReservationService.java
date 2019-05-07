package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Reservation;

import java.time.LocalDate;

public interface ReservationService {
    Iterable<Reservation> getBookingsByDates(LocalDate dateIn, LocalDate dateOut);

    void delete(Long id);

    Reservation save(Reservation reservation);

    Iterable<Reservation> findAll();

}
