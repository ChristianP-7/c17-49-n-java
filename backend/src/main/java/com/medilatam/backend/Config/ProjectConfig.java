package com.medilatam.backend.Config;

import com.cloudinary.Cloudinary;
import com.medilatam.backend.Security.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProjectConfig {

    //Recibe una contraseña para poder encriptarla
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Utiliza tu implementación personalizada de PasswordEncoder
        return new CustomPasswordEncoder(); // Requiere al menos 6 caracteres
    }

    @Value("${cloudinary.url}")
    private String cloudinaryUrl;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(cloudinaryUrl);
    }

}
