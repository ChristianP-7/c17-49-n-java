package com.medilatam.backend.Dto;

import com.medilatam.backend.Entity.Doctor;
import com.medilatam.backend.Security.Enums.EstadoConsulta;
import com.medilatam.backend.Entity.PersonaEntity;
import com.medilatam.backend.Entity.TipoConsulta;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class ConsultaDto {
    
    @NotBlank
    private Date fecha;
    
    @NotBlank
    private Doctor doctor;
    
    @NotBlank
    private EstadoConsulta estadoConsulta;
    
    @NotBlank
    private TipoConsulta tipoConsulta;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private PersonaEntity persona;

    public ConsultaDto() {
    }

    public ConsultaDto(Date fecha, Doctor doctor, EstadoConsulta estadoConsulta, TipoConsulta tipoConsulta, String descripcion, PersonaEntity persona) {
        this.fecha = fecha;
        this.doctor = doctor;
        this.estadoConsulta = estadoConsulta;
        this.tipoConsulta = tipoConsulta;
        this.descripcion = descripcion;
        this.persona = persona;
    }
    
    
    
    

}