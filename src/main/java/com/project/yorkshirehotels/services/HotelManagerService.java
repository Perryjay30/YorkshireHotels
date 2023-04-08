package com.project.yorkshirehotels.services;

import com.project.yorkshirehotels.data.dto.request.LoginRequest;
import com.project.yorkshirehotels.data.dto.request.RegistrationRequest;
import com.project.yorkshirehotels.data.dto.request.UpdateRequest;
import com.project.yorkshirehotels.data.dto.request.VerifyOtpRequest;
import com.project.yorkshirehotels.data.dto.response.Reciprocation;
import com.project.yorkshirehotels.data.dto.response.Response;
import com.project.yorkshirehotels.data.models.HotelManager;

public interface HotelManagerService {
    String HotelManagerRegistration(RegistrationRequest registrationRequest);

    Reciprocation createAccount(VerifyOtpRequest verifyOtpRequest);

    Response login(LoginRequest loginRequest);

    HotelManager findHotelManagerById(String hotelManagerId);

    Response updateHotelManagerDetails(UpdateRequest updateRequest);

    Response deleteAccount(String id);
}
