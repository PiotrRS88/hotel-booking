package com.example.hotelbooking.controllers;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.service.ReservationService;
import com.example.hotelbooking.service.reservation_dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @PostMapping
    public Reservation addReservation(@RequestBody ReservationDTO reservationDto) {
        return reservationService.save(reservationDto);
    }

    @DeleteMapping
    public String cancelReservation(@RequestParam Long id) {
        reservationService.delete(id);
        return "Reservation has been canceled";
    }

    @GetMapping("/booked")
    public Iterable<Reservation> getAllBookings(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOut) {
        return reservationService.getBookingsByDates(dateIn, dateOut);
    }

    @GetMapping("/empty")
    public Iterable<Reservation> getEmpty() {
        return reservationService.getEmptyRooms();
    }

    @GetMapping("/free")
    public List<Long> findFreeRoomsByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOut) {
        return reservationService.findFreeRoomsByDate(dateIn, dateOut);
    }

}
