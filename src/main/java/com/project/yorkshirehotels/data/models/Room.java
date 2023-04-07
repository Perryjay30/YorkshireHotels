package com.project.yorkshirehotels.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Document
public class Room {
    @Id
    private String roomId;
    private String roomNumber;
    private BigInteger roomPrice;
    private RoomStatus roomStatus;
}
