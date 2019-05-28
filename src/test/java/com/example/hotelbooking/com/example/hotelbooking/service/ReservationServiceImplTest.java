package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.entities.Room;
import com.example.hotelbooking.repositories.GuestRepository;
import com.example.hotelbooking.repositories.ReservationRepository;
import com.example.hotelbooking.repositories.RoomRepository;
import com.example.hotelbooking.service.reservation_dto.ReservationDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class ReservationServiceImplTest {
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;
    @Mock
    ReservationRepository reservationRepository;
    @InjectMocks
    ReservationServiceImpl reservationServiceImpl;
    @InjectMocks
    ReservationDTO reservationDTO;

    //    @Before
//    public void listOfGuestsToTest() {
//
//        Guest g1 = new Guest("Adam", "Mickiewicz", "szarkiewicz@gmail.com");
//        guestRepository.save(g1);
//
//        Guest g2 = new Guest("Henryk", "Sienkiewicz", "szarkiewicz@gmail.com");
//        guestRepository.save(g2);
//
//        Room room1 = new Room(1);
//        Room room2 = new Room(2);
//        Room room3 = new Room(3);
//        Room room4 = new Room(4);
//        roomRepository.save(room1);
//        roomRepository.save(room2);
//        roomRepository.save(room3);
//        roomRepository.save(room4);
//
//        LocalDate localDate1 = LocalDate.of(2019, 05, 13);
//        LocalDate localDate2 = LocalDate.of(2019, 05, 15);
//
//        LocalDate localDate3 = LocalDate.of(2019, 06, 14);
//        LocalDate localDate4 = LocalDate.of(2019, 06, 17);
//
//        LocalDate localDate5 = LocalDate.of(2019, 07, 02);
//        LocalDate localDate6 = LocalDate.of(2019, 07, 06);
//
//        Reservation r1 = new Reservation(localDate1, localDate2, g1, room1);
//        Reservation r2 = new Reservation(localDate3, localDate4, g1, room2);
//        Reservation r3 = new Reservation(localDate5, localDate6, g2, room3);
//        reservationRepository.save(r1);
//        reservationRepository.save(r2);
//        reservationRepository.save(r3);
//    }
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getBookingsByDates() {
    }

    @Test
    public void getEmptyRooms() {
    }

    @Test
    public void delete() {
        List<Reservation> list = new ArrayList<>();

        Reservation reservation = new Reservation();
        reservation.setId(1L);
        Room room = new Room();
        room.setNumber(1);
        LocalDate localDate1 = LocalDate.of(2019, 05, 13);
        LocalDate localDate2 = LocalDate.of(2019, 05, 15);
        reservation.setDateIn(localDate1);
        reservation.setDateOut(localDate2);
        reservation.setRoom(room);


    }

    @Test
    public void save() {
        Reservation res = new Reservation();
        Room room = new Room();
        room.setNumber(1);
        LocalDate localDate1 = LocalDate.of(2019, 05, 13);
        LocalDate localDate2 = LocalDate.of(2019, 05, 15);
        res.setDateIn(localDate1);
        res.setDateOut(localDate2);
        res.setRoom(room);


//        Mockito.when(reservationRepository.findFreeRoomsByDatesAndId(res.getRoom().getNumber())).thenReturn(res);

    }

    @Test
    public void findAll() {
        List<Reservation> list = new ArrayList<>();

        Reservation reservation = new Reservation();
        Room room = new Room();
        room.setNumber(1);
        LocalDate localDate1 = LocalDate.of(2019, 05, 13);
        LocalDate localDate2 = LocalDate.of(2019, 05, 15);
        reservation.setDateIn(localDate1);
        reservation.setDateOut(localDate2);
        reservation.setRoom(room);

        when(reservationRepository.findAll()).thenReturn(list);

        list.add(reservation);

        assertEquals(1, list.size());

    }

    @Test
    public void findFreeRoomsByDate() {
    }
}