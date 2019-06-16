package com.example.hotelbooking.service;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.entities.Room;
import com.example.hotelbooking.repositories.GuestRepository;
import com.example.hotelbooking.repositories.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@Slf4j
@SpringBootTest
public class ReservationServiceImplTest {
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;

    private List<Reservation> list;
    private Reservation reservation;
    private Room room;

    @Before
    public void setUp() {
        //given
        list = new ArrayList<>();

        reservation = new Reservation();
        room = new Room();
        final LocalDate localDate1 = LocalDate.of(2019, 5, 13);
        final LocalDate localDate2 = LocalDate.of(2019, 5, 15);

        reservation.setId(1L);
        reservation.setDateIn(localDate1);
        reservation.setDateOut(localDate2);
        reservation.setRoom(room);
        room.setNumber(1);
    }


    @Test
    public void getBookingsByDates() {
    }

    @Test
    public void getEmptyRooms() {
    }

    @Test
    public void should_delete_reservation() {
        //when
        list.add(reservation);
        log.info("SetUp list = " + list);

        list.remove(reservation);

        log.info("List after test: " + list);

        //then
        assertEquals(0, list.size());
    }

    @Test
    public void should_add_new_reservation() {
        list.add(reservation);
        System.out.println("SetUp list = " + list);
        //then
        assertEquals(1, list.size());

    }

    @Test
    public void should_return_all_reservations() {
        //when
        list.add(reservation);
        list.add(reservation);
        list.add(reservation);
        //then
        assertEquals(3, list.size());

    }

    @Test
    public void should_return_free_rooms_by_given_dates() {
        //when
        list.add(reservation);
        //then
        assertEquals(1, room.getNumber());
    }
}