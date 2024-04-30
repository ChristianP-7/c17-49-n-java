package com.medilatam.backend.Dto;

import com.medilatam.backend.Security.Enums.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.util.Date;

//Deprecable??
@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
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
    private String password;

    @Null(message = "Este campo debe ser nulo al principio")
    private String foto;

}
