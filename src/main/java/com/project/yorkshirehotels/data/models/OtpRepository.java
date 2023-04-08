package com.project.yorkshirehotels.data.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OtpRepository extends MongoRepository<OTPToken, String> {
}
