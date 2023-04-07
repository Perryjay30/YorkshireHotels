package com.project.yorkshirehotels.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "This field is required")
    private String emailAddress;
    @NotBlank(message = "This field is required")
    private String password;

}
