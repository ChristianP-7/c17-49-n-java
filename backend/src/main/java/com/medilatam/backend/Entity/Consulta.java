package com.medilatam.backend.Entity;


import com.medilatam.backend.Security.Enums.EstadoConsulta;
import com.medilatam.backend.Security.Enums.TipoConsulta;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @Builder
@Table(name = "consulta")

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paciente_id")
    private PersonaEntity paciente;

    @NotBlank
    @Size(min=1, max=30, message="Número de caracteres incorrectos")
    @JoinColumn(name="doctor_especialidad", nullable = false)
    private String especialidad;

    @NotNull
    @Column(name = "precio", nullable = false)
    private Float precio;

    @NotNull
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @NotNull
    @Size(min=1,max=500, message="Número de caracteres incorrectos")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoConsulta estado;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoConsulta tipo;

   @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "celular", nullable = false)
    private Long celular;

    @NotNull
    @Column(name = "calificacion", nullable = false)
    private Float calificacion;
}
