package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public static void validateDate(LocalDate in, LocalDate out) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateTimeFormatter.format(in);
        dateTimeFormatter.format(out);

        if (in.isAfter(out)) throw new RuntimeException("DateIn can't be after dateOut!") {
        };
    }

    @Override
    public Iterable<Reservation> getBookingsByDates(LocalDate dateIn, LocalDate dateOut) {
        validateDate(dateIn, dateOut);
        return reservationRepository.findAllByDateInGreaterThanEqualAndDateOutLessThanEqual(dateIn, dateOut);
    }

    public Iterable<Reservation> getEmptyRooms() {
        return reservationRepository.findRoomsWithoutAnyReservation();
    }


    @Override
    public void delete(Long id) {
        //czy usuwa swój booking (id uzytkownika oraz id rezerwacji czy do niego nalezy)
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }


}
