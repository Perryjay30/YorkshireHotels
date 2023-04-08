package com.project.yorkshirehotels.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SendTokenRequest {
    @NotBlank(message = "This field is required")
    private String email;
}
