package com.medilatam.backend.Dto;

import com.medilatam.backend.Entity.Genero;
import com.medilatam.backend.Security.ValidPassword;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
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
    @ValidPassword
    private String password;

    @Null(message = "Este campo debe ser nulo al principio")
    private String foto;

}
