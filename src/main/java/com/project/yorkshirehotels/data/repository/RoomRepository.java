package com.project.yorkshirehotels.data.repository;

import com.project.yorkshirehotels.data.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room, String> {
    Optional<Room> findRoomByRoomNumber(String roomNumber);
}
