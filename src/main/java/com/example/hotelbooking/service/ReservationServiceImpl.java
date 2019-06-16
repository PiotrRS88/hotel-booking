package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Guest;
import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.entities.Room;
import com.example.hotelbooking.repositories.GuestRepository;
import com.example.hotelbooking.repositories.ReservationRepository;
import com.example.hotelbooking.repositories.RoomRepository;
import com.example.hotelbooking.service.reservation_dto.ReservationDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static com.example.hotelbooking.service.date_validator.DateValidator.validateDate;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
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
        reservationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Reservation save(ReservationDTO reservationDto) {

        validateDate(reservationDto.getDateIn(), reservationDto.getDateOut());

        final List<Long> availableRoomIds = reservationRepository.findFreeRoomsByDatesAndId(
                reservationDto.getDateIn(),
                reservationDto.getDateOut(),
                reservationDto.getRoomId());
        if (availableRoomIds.isEmpty()) {
            throw new RuntimeException("This room cannot be booked at the given period of time.");
        }

        Reservation reservation = new Reservation();
        reservation.setDateIn(reservationDto.getDateIn());
        reservation.setDateOut(reservationDto.getDateOut());

        final Room roomToBook = roomRepository.findById(reservationDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room has not been found."));
        reservation.setRoom(roomToBook);

        final Guest guest = guestRepository.findById(reservationDto.getGuestId())
                .orElseThrow(() -> new RuntimeException("Guest has not been found."));

        reservation.setGuest(guest);

        return reservationRepository.save(reservation);
    }


    @Override
    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Long> findFreeRoomsByDate(LocalDate dateIn, LocalDate dateOut) {
        validateDate(dateIn, dateOut);

        return reservationRepository.findFreeRoomsByDate(dateIn, dateOut);
    }
}
