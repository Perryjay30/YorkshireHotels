package com.project.yorkshirehotels.utils;

public class Validators {
    public static boolean validatePassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
    }

    public static boolean validateStaffVIN(String staffVIN) {
        return staffVIN.contains("S");
    }

    public static boolean validateEmailAddress(String email) {
        return email.matches("^(.+)@(\\S+)$");
    }
}
