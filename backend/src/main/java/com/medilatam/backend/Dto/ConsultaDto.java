package com.medilatam.backend.Dto;

import com.medilatam.backend.Entity.Doctor;
import com.medilatam.backend.Security.Enums.EstadoConsulta;
import com.medilatam.backend.Entity.PersonaEntity;
import com.medilatam.backend.Security.Enums.TipoConsulta;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor

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





}