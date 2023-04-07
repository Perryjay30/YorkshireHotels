package com.project.yorkshirehotels.data.repository;

import com.project.yorkshirehotels.data.models.HotelManager;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelManagerRepository extends MongoRepository<HotelManager, String> {
}
