package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.service.reservation_dto.ReservationDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    Iterable<Reservation> getBookingsByDates(LocalDate dateIn, LocalDate dateOut);

    Iterable<Reservation> getEmptyRooms();

    void delete(Long id);

    Reservation save(ReservationDTO reservationDto);

    Iterable<Reservation> findAll();

    List<Long> findFreeRoomsByDate(LocalDate dateIn, LocalDate dateOut);
}
