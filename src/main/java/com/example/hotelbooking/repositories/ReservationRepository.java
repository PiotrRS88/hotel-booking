package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAllByDateInGreaterThanEqualAndDateOutLessThanEqual(LocalDate dateIn, LocalDate dateOut);

    @Query(value = "SELECT r.* FROM room r LEFT JOIN reservation rs ON rs.room_id = r.id WHERE rs.id IS NULL", nativeQuery = true)
    List<Reservation> findRoomsWithoutAnyReservation();


    @Query(value = "SELECT count(r.id) FROM room r\n" +
            "                          LEFT JOIN reservation rs ON rs.room_id = r.id\n" +
            "WHERE (rs.date_in < :dateIn AND rs.date_out <= :dateOut)\n" +
            "   OR (rs.date_in >= :dateIn AND rs.date_out > :dateOut)\n" +
            "   OR rs.id IS NULL;", nativeQuery = true)
    int findFreeRooms(@Param("dateIn") LocalDate dateIn, @Param("dateOut") LocalDate dateOut);

    @Query(value = "SELECT rs.* FROM reservation rs LEFT JOIN room r ON rs.room_id = r.id WHERE rs.id IS NOT NULL", nativeQuery = true)
    List<Reservation> findBookedRooms();

    @Query(value = "SELECT r.id FROM room r LEFT JOIN reservation rs ON rs.room_id = r.id\n" +
            "WHERE (rs.date_in < :dateIn AND rs.date_out <= :dateOut)\n" +
            "   OR (rs.date_in >= :dateIn AND rs.date_out > :dateOut)\n" +
            "   OR rs.id IS NULL;", nativeQuery = true)
    List<Long> findFreeRoomsByDate(@Param("dateIn") LocalDate dateIn, @Param("dateOut") LocalDate dateOut);


    @Query(value = "SELECT r.id FROM room r LEFT JOIN reservation rs ON rs.room_id = r.id\n" +
            "WHERE\n" +
            "    r.id = :roomId\n" +
            "  AND (((rs.date_in < :dateIn) AND (rs.date_out <= :dateIn))\n" +
            "   OR ((rs.date_in >= :dateOut) AND (rs.date_out > :dateOut))\n" +
            "  OR rs.id IS NULL);", nativeQuery = true)
    List<Long> findFreeRoomsByDatesAndId(@Param("dateIn") LocalDate dateIn, @Param("dateOut") LocalDate dateOut, @Param("roomId") Long roomId);


    @Query(value = "SELECT g.email FROM guest g LEFT JOIN reservation rs ON rs.guest_id = g.id WHERE (CURRENT_DATE + INTERVAL 1 DAY ) = rs.date_in", nativeQuery = true)
    List<String> findEmailToRemind();
}
