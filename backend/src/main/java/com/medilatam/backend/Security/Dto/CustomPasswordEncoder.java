package com.medilatam.backend.Security.Dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final int minLength;

    public CustomPasswordEncoder() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.minLength = 6;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        String password = rawPassword.toString();

        // Verifica si la contraseña cumple con los requisitos mínimos
        if (password.length() < minLength) {
            throw new IllegalArgumentException("La contraseña debe tener al menos " + minLength + " caracteres");
        }
        if (!containsUppercase(password)) {
            throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula");
        }
        if (!containsDigit(password)) {
            throw new IllegalArgumentException("La contraseña debe contener al menos un carácter numérico");
        }

        // Codifica la contraseña utilizando BCryptPasswordEncoder
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Verifica si la contraseña en texto plano coincide con la versión codificada
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }

    private boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}