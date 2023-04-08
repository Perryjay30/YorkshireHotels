package com.project.yorkshirehotels.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddRoomRequest {
    @NotBlank(message = "This field is required")
    private String roomNumber;
    @NotBlank(message = "This field is required")
    private String roomType;
    @NotBlank(message = "This field is required")
    private BigDecimal roomPrice;
    @NotBlank(message = "This field is required")
    private String roomStatus;
}
