package com.project.yorkshirehotels.utils;

import java.security.SecureRandom;

public class Token {

    private static final SecureRandom  secureRandom = new SecureRandom();

    public static String generateToken() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(secureRandom.nextInt(9));
        }
        return stringBuilder.toString();
    }
}
