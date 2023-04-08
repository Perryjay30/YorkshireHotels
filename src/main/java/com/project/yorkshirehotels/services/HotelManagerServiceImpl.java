package com.project.yorkshirehotels.services;

import com.project.yorkshirehotels.data.dto.request.*;
import com.project.yorkshirehotels.data.dto.response.Reciprocation;
import com.project.yorkshirehotels.data.dto.response.Response;
import com.project.yorkshirehotels.data.models.HotelManager;
import com.project.yorkshirehotels.data.models.OTPToken;
import com.project.yorkshirehotels.data.models.OtpRepository;
import com.project.yorkshirehotels.data.models.Status;
import com.project.yorkshirehotels.data.repository.HotelManagerRepository;
import com.project.yorkshirehotels.utils.Token;
import com.project.yorkshirehotels.utils.Validators;
import com.project.yorkshirehotels.utils.YorkShireHotelsException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HotelManagerServiceImpl implements HotelManagerService {

    private final HotelManagerRepository hotelManagerRepository;

    private final OtpRepository otpRepository;

    private final EmailService emailService;

    public HotelManagerServiceImpl(HotelManagerRepository hotelManagerRepository, OtpRepository otpRepository, EmailService emailService) {
        this.hotelManagerRepository = hotelManagerRepository;
        this.otpRepository = otpRepository;
        this.emailService = emailService;
    }


    @Override
    public String HotelManagerRegistration(RegistrationRequest registrationRequest) {
        HotelManager hotelManager = new HotelManager();
        registeringHotelManager(registrationRequest, hotelManager);
        stillOnTheRegistration(registrationRequest, hotelManager);
        SendTokenRequest sendTokenRequest = new SendTokenRequest();
        sendTokenRequest.setEmail(registrationRequest.getEmailAddress());
        return sendOtpToken(sendTokenRequest);
    }

    private void stillOnTheRegistration(RegistrationRequest registrationRequest, HotelManager hotelManager) {
        if(!Validators.validateStaffVIN(registrationRequest.getStaffVIN()))
            throw new YorkShireHotelsException("StaffVIN is not registered");
        else
            hotelManager.setStaffVIN(registrationRequest.getStaffVIN());
        hotelManager.setPassword(registrationRequest.getPassword());
        hotelManager.setLastName(registrationRequest.getLastName());
        hotelManager.setStatus(Status.UNVERIFIED);
        hotelManagerRepository.save(hotelManager);
    }

    private void registeringHotelManager(RegistrationRequest registrationRequest, HotelManager hotelManager) {
        if(!Validators.validateEmailAddress(registrationRequest.getEmailAddress()))
            throw new YorkShireHotelsException(String.format("Email address %s is invalid", registrationRequest.getEmailAddress()));
        if(hotelManagerRepository.findByEmailAddress(registrationRequest.getEmailAddress()).isPresent())
            throw new YorkShireHotelsException("This email has been taken, kindly register with another email address");
        else
            hotelManager.setEmailAddress(registrationRequest.getEmailAddress());
        hotelManager.setPassword(registrationRequest.getPassword());
        hotelManager.setFirstName(registrationRequest.getFirstName());
    }

    private String sendOtpToken(SendTokenRequest sendTokenRequest) {
        HotelManager savedHotelManager = findHotelManager(sendTokenRequest.getEmail());
        return generateOtpToken(sendTokenRequest, savedHotelManager);
    }

    private String generateOtpToken(SendTokenRequest sendTokenRequest, HotelManager savedHotelManager) {
        String token = Token.generateToken();
        OTPToken otpToken = new OTPToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(10), savedHotelManager);
        otpRepository.save(otpToken);
        emailService.send(sendTokenRequest.getEmail(), emailService.buildEmail(savedHotelManager.getFirstName(), token));
        return "Token successfully sent to your email. Please check.";
    }

    private HotelManager findHotelManager(String emailAddress) {
        return hotelManagerRepository.findByEmailAddress(emailAddress)
                .orElseThrow(() -> new YorkShireHotelsException("Email is not registered"));
    }

    @Override
    public Reciprocation createAccount(VerifyOtpRequest verifyOtpRequest) {
        return null;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Response updateHotelManagerDetails(UpdateRequest updateRequest) {
        return null;
    }

    @Override
    public Response deleteAccount(String id) {
        return null;
    }
}