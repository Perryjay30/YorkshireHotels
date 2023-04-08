package com.project.yorkshirehotels.services;

import com.project.yorkshirehotels.data.dto.request.RegistrationRequest;
import com.project.yorkshirehotels.data.dto.response.Reciprocation;
import com.project.yorkshirehotels.utils.YorkShireHotelsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelManagerServiceImplTest {

    @Autowired
    private HotelManagerService hotelManagerService;

    @Test
    void testThatHotelManagerCanRegister() {
        RegistrationRequest register = new RegistrationRequest();
        register.setFirstName("Damilola");
        register.setLastName("Taiwo");
        register.setEmailAddress("Dondamzy99@gmail.com");
        register.setPassword("Dondamzy@99");
        register.setStaffVIN("SQ7801264");
        String reply = hotelManagerService.HotelManagerRegistration(register);
        assertEquals("Token successfully sent to your email. Please check.", reply);
    }

    @Test
    void testThatHotelManagerCanRegisterThrowsException() {
        RegistrationRequest register = new RegistrationRequest();
        register.setFirstName("Damilola");
        register.setLastName("Taiwo");
        register.setEmailAddress("Dondamzy99gmail.com");
        register.setPassword("Dondamzy");
        register.setStaffVIN("SQ7801264");
        assertThrows(YorkShireHotelsException.class, () -> hotelManagerService.HotelManagerRegistration(register));
    }
}