package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.repositories.ReservationRepository;
import com.example.hotelbooking.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
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
        validateDate(reservation.getDateIn(), reservation.getDateOut());
        int countOfFreeRooms = reservationRepository.findFreeRooms(reservation.getDateIn(), reservation.getDateOut());
        if (countOfFreeRooms > 0)
            return reservationRepository.save(reservation);

        else {
            // nie ma wolnego
        }
        return null;
    }


    @Override
    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Integer> findFreeRoomsByDate(LocalDate dateIn, LocalDate dateOut) {
        validateDate(dateIn, dateOut);

        return reservationRepository.findFreeRoomsByDate(dateIn, dateOut);
    }


}
