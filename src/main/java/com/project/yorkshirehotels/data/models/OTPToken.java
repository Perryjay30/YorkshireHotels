package com.project.yorkshirehotels.data.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@RequiredArgsConstructor
public class OTPToken {
    @Id
    private String id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private LocalDateTime verifiedAt;
    @DBRef
    private HotelManager hotelManager;

    public OTPToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, HotelManager hotelManager) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.hotelManager = hotelManager;
    }
}
