package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.entities.Room;
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
    int findFreeRooms(@Param("dateIn") LocalDate dateIn,@Param("dateOut") LocalDate dateOut);

    @Query(value = "SELECT r.id FROM room r LEFT JOIN reservation rs ON rs.room_id = r.id\n" +
            "WHERE (rs.date_in < :dateIn AND rs.date_out <= :dateOut)\n" +
            "   OR (rs.date_in >= :dateIn AND rs.date_out > :dateOut)\n" +
            "   OR rs.id IS NULL;", nativeQuery = true)
    List<Integer>  findFreeRoomsByDate(@Param("dateIn") LocalDate dateIn, @Param("dateOut") LocalDate dateOut);



    //filtrowanie wszystkich wolnych pokoi
    //wyszukać listę pokoi które nie maja zadnych rezerwacji w danym okresie
}
