package com.project.yorkshirehotels.data.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OtpRepository extends MongoRepository<OTPToken, String> {
    Optional<OTPToken> findByToken(String token);
}
