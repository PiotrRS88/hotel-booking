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
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
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
        Guest guest1 = new Guest("Adam", "Mickiewicz", "szarkiewicz@gmail.com");
        guestRepository.save(guest1);

        Guest guest2 = new Guest("Henryk", "Sienkiewicz", "szarkiewicz@gmail.com");
        guestRepository.save(guest2);

        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);
        Room room4 = new Room(4);
        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);
        roomRepository.save(room4);

        LocalDate localDate1 = LocalDate.of(2019, 5, 13);
        LocalDate localDate2 = LocalDate.of(2019, 5, 15);

        LocalDate localDate3 = LocalDate.of(2019, 6, 14);
        LocalDate localDate4 = LocalDate.of(2019, 6, 17);

        LocalDate localDate5 = LocalDate.of(2019, 7, 2);
        LocalDate localDate6 = LocalDate.of(2019, 7, 6);

        Reservation reservation1 = new Reservation(localDate1, localDate2, guest1, room1);
        Reservation reservation2 = new Reservation(localDate3, localDate4, guest1, room2);
        Reservation reservation3 = new Reservation(localDate5, localDate6, guest2, room3);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
    }
}
