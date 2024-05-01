package com.medilatam.backend.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor

@Getter @Setter @Builder
public class DoctorDto {
    
    @NotNull
    private String nombre;

    @NotNull
    private String especialidad;

    @NotNull
    private String horarioAtencion;

    @NotNull
    private String localidad;

    @NotNull
    private Integer costoConsulta;

    /*
    @NotNull
    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    private String pais;
    */

    @NotNull @NotBlank
    private  String telefono;
}
