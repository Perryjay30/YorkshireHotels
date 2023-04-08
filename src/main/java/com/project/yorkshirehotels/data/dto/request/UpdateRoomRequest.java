package com.project.yorkshirehotels.data.dto.request;

import com.project.yorkshirehotels.data.models.RoomStatus;
import com.project.yorkshirehotels.data.models.RoomType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class UpdateRoomRequest {
    @NotBlank(message = "This field is required")
    private String roomNumber;
    @NotBlank(message = "This field is required")
    private RoomType roomType;
    @NotBlank(message = "This field is required")
    private BigDecimal roomPrice;
    @NotBlank(message = "This field is required")
    private RoomStatus roomStatus;
}
