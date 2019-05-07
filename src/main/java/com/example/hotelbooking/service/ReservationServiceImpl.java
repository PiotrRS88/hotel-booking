package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Iterable<Reservation> getBookingsByDates(LocalDate dateIn, LocalDate dateOut) {
        //walidacje daty- miesiecy/roku... biblioteki do walidacji daty
        return reservationRepository.findAllByDateInGreaterThanEqualAndDateOutLessThanEqual(dateIn, dateOut);
    }

    @Override
    public void delete(Long id) {
        //czy usuwa swój booking (id uzytkownika oraz id rezerwacji czy do niego nalezy)
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return null;
    }

    @Override
    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
