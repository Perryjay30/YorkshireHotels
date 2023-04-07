package com.project.yorkshirehotels.data.dto.request;

import lombok.Data;

@Data
public class UpdateRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private String staffVIN;
}
