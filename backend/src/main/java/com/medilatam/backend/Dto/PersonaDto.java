package com.medilatam.backend.Dto;

import com.medilatam.backend.Entity.Genero;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {

    private Long id;

    @NotBlank(message = "Este campo es obligatorio")
    private String name;

    @NotBlank(message = "Este campo es obligatorio")
    private Date fechaNacimiento;

    @NotBlank(message = "Este campo es obligatorio")
    private Genero genero;

    @NotBlank(message = "Este campo es obligatorio")
    private String pais;

    @NotBlank(message = "Este campo es obligatorio")
    private String provincia;

    @NotBlank(message = "Este campo es obligatorio")
    private String email;

    @NotBlank(message = "Este campo es obligatorio")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).*$", message = "La contraseña debe contener al menos una mayúscula y un dígito")
    private String password;

    @Null(message = "Este campo debe ser nulo al principio")
    private String foto;

}
