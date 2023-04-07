package com.project.yorkshirehotels.data.repository;

import com.project.yorkshirehotels.data.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
