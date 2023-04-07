package com.project.yorkshirehotels.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class HotelManager {
    @Id
    private String HotelManagerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private String staffVIN;
}
