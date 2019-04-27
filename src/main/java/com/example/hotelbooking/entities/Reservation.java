package com.example.hotelbooking.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_in")
    private LocalDate dateIn;

    @Column(name = "date_out")
    private LocalDate dateOut;


    @ManyToOne
    private Guest guest;

    @OneToOne
    private Room room;

    public Reservation() {
    }

    public Reservation(LocalDate dateIn, LocalDate dateOut, Guest guest, Room room) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.guest = guest;
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';
    }
}
