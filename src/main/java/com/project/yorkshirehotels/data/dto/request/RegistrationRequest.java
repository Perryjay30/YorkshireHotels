package com.project.yorkshirehotels.data.dto.request;

import com.project.yorkshirehotels.utils.Validators;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

@Data
public class RegistrationRequest {
    @NotBlank(message = "This field cannot be empty")
    private String firstName;
    @NotBlank(message = "This field cannot be empty")
    private String lastName;
    @NotBlank(message = "This field cannot be empty")
    private String emailAddress;
    @NotBlank(message = "This field cannot be empty")
    private String password;
    @NotBlank(message = "This field cannot be empty")
    private String staffVIN;

    public String getPassword() {
        if(Validators.validatePassword(password))
            return BCrypt.hashpw(password, BCrypt.gensalt());
        else
            throw new RuntimeException("password is invalid");
    }
}
