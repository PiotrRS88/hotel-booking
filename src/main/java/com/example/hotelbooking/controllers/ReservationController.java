package com.example.hotelbooking.controllers;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller //wynik w postaci templatki, a nie json- tak jak @RestController
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
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @DeleteMapping
    public String cancelReservation(@RequestParam Long id) {
        reservationService.delete(id);
        return "cancelReservationResult";
    }

    @GetMapping("/booked")
    public Iterable<Reservation> getAllBookings(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOut) {
        return reservationService.getBookingsByDates(dateIn, dateOut);
    }

}
