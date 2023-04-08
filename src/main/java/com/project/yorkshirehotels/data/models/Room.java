package com.project.yorkshirehotels.data.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
@Builder
public class Room {
    @Id
    private String roomId;
    private String roomNumber;
    private BigDecimal roomPrice;
    private RoomType roomType;
    private RoomStatus roomStatus;
}
