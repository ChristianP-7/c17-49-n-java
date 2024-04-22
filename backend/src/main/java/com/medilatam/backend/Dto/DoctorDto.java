package com.medilatam.backend.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class DoctorDto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String especialidad;
    @NotBlank
    private String horarioAtencion;
    @NotBlank
    private String localidad;
    @NotBlank
    private Integer costoConsulta;

    
    //Constructor
    public DoctorDto() {
    }

    public DoctorDto(String nombre, String especialidad, String horarioAtencion, String localidad, Integer costoConsulta) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horarioAtencion = horarioAtencion;
        this.localidad = localidad;
        this.costoConsulta = costoConsulta;
    }
}
