package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
