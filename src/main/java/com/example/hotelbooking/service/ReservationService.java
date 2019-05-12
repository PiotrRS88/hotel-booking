package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.entities.Room;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    Iterable<Reservation> getBookingsByDates(LocalDate dateIn, LocalDate dateOut);

    Iterable<Reservation> getEmptyRooms();


    void delete(Long id);

    Reservation save(Reservation reservation);

    Iterable<Reservation> findAll();

    List<Integer> findFreeRoomsByDate(LocalDate dateIn, LocalDate dateOut);
}
