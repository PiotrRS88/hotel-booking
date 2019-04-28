package com.example.hotelbooking;

import com.example.hotelbooking.entities.Guest;
import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.entities.Room;
import com.example.hotelbooking.repositories.GuestRepository;
import com.example.hotelbooking.repositories.ReservationRepository;
import com.example.hotelbooking.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;

@SpringBootApplication
public class HotelBookingApplication {
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ReservationRepository reservationRepository;

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Guest g1 = new Guest("Piotr", "Kowalski");
        guestRepository.save(g1);

        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);
        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);

        LocalDate localDate1 = LocalDate.of(2019, 06, 10);
        LocalDate localDate2 = LocalDate.of(2019, 06, 14);
        LocalDate localDate3 = LocalDate.of(2019, 06, 15);
        LocalDate localDate4 = LocalDate.of(2019, 06, 17);
        Reservation r1 = new Reservation(localDate1, localDate2, g1, room1);
        Reservation r2 = new Reservation(localDate3, localDate4, g1, room2);
        reservationRepository.save(r1);
        reservationRepository.save(r2);



    }
}
