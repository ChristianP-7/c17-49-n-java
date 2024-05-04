package com.medilatam.backend.Entity;

import com.medilatam.backend.Security.Enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "name", nullable = false)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @NotNull(message = "Este campo es obligatorio")
    @Column(name = "genero")
    private Genero genero;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "pais")
    private String pais;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "provincia")
    private String provincia;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(min=6, max=70, message = "Mínimo seis caracteres , una mayúscula y un número")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$", message = "Mínimo seis caracteres , una mayúscula y un número")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "foto")
    private String foto;
}
