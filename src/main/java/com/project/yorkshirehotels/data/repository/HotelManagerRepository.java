package com.project.yorkshirehotels.data.repository;

import com.project.yorkshirehotels.data.models.HotelManager;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HotelManagerRepository extends MongoRepository<HotelManager, String> {
    Optional<HotelManager> findByEmailAddress(String emailAddress);
}
