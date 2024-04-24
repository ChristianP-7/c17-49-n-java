package com.medilatam.backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Doctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    private String especialidad;
    
    @NotNull
    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    private String horarioAtencion;
    
    @NotNull
    @Size(min = 1, max = 70, message = "Faltan o sobran caracteres")
    private String localidad;
    
    @NotNull
    private Integer costoConsulta;


    private Float calificacion;

    
    //Constructors
    public Doctor() {
    }

    /*
    No está siendo usado, pero igualmente lo dejamos
    De todas formas, si al final vemos que no lo necesitamos podemos deprecar esta sección de código
     */
    public Doctor(String nombre, String especialidad, String horarioAtencion, String localidad, Integer costoConsulta) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horarioAtencion = horarioAtencion;
        this.localidad = localidad;
        this.costoConsulta = costoConsulta;
    }
    
    
}
