package com.example.hotelbooking.service.reservation_dto;

import java.time.LocalDate;

public class ReservationDTO {
    private Long roomId;
    private LocalDate dateIn;
    private LocalDate dateOut;
    private Long guestId;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }
    @Override
    public String toString() {
        return "ReservationDTO{" +
                "roomId=" + roomId +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';

    }
}
