package com.project.yorkshirehotels.data.dto.request;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String staffVIN;
}
