package com.project.yorkshirehotels.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document
public class Guest {
    @Id
    private String guestId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private RoomType roomType;
    private String checkinDate;
    private String checkoutDate;
    private BigInteger roomPrice;
    private PaymentStatus paymentStatus;
}
