package com.project.yorkshirehotels.data.repository;

import com.project.yorkshirehotels.data.models.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRepository extends MongoRepository<Guest, String> {
}
