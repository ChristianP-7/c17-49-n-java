package com.medilatam.backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "genero", nullable = false)
    private Genero genero;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "provincia", nullable = false)
    private String provincia;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).*$", message = "La contraseña debe contener al menos una mayúscula y un dígito")
    private String password;

    @Column(name = "foto")
    private String foto;
}
