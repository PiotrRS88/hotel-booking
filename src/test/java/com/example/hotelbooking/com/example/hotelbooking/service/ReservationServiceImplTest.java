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
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

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
//    public void init(){
//        MockitoAnnotations.initMocks(this);
//    }

    @Before
    public void setUp() {
        //given
        list = new ArrayList<>();

        reservation = new Reservation();
        room = new Room();
        localDate1 = LocalDate.of(2019, 05, 13);
        localDate2 = LocalDate.of(2019, 05, 15);

        reservation.setId(1L);
        reservation.setDateIn(localDate1);
        reservation.setDateOut(localDate2);
        reservation.setRoom(room);
        room.setNumber(1);
    }

    private List<Reservation> list;
    private Reservation reservation;
    private Room room;
    private LocalDate localDate1;
    private LocalDate localDate2;


    @Test
    public void getBookingsByDates() {
    }

    @Test
    public void getEmptyRooms() {
    }

    @Test
    public void delete() {
        //when
        list.add(reservation);
        System.out.println("SetUp list = " + list);

//        when(reservationServiceImpl.delete(1L));

        list.remove(reservation);

        System.out.println("List after test: " + list);

        //then
        assertEquals(0, list.size());
    }

    @Test
    public void save() {
//        Mockito.when(reservationRepository.findFreeRoomsByDatesAndId(res.getRoom().getNumber())).thenReturn(res);
        //when
        list.add(reservation);
        System.out.println("SetUp list = " + list);
        //then
        assertEquals(1, list.size());

    }

    @Test
    public void findAll() {
        //        when(reservationRepository.findAll()).thenReturn(list);

        //when
        list.add(reservation);
        list.add(reservation);
        list.add(reservation);
        //then
        assertEquals(3, list.size());

    }

    @Test
    public void findFreeRoomsByDate() {
    }
}