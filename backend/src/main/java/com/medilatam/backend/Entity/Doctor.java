package com.medilatam.backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @Builder
public class Doctor {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    @Column(name = "especialidad", nullable = false)
    private String especialidad;
    

    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    @Column(name = "horarioAtencion", nullable = false)
    private String horarioAtencion;


    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    @Column(name = "localidad", nullable = false)
    private String localidad;


    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    @Column(name = "pais")
    private String pais;


    @Column(name = "costoConsulta", nullable = false)
    private Integer costoConsulta;

    @Column(name = "calificacion", nullable = false)
    private Float calificacion;


    @Column(name = "telefono", unique = true)
    private  Integer telefono;
    
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(min=6, max=70, message = "Mínimo seis caracteres , una mayúscula y un número")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$", message = "Mínimo seis caracteres , una mayúscula y un número")
    @Column(name = "password", nullable = false)
    private String password;


}
