package com.medilatam.backend.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor

// Esta es la clase que se encarga de recibir los datos de la consulta para convertirlos en un objeto de tipo Consulta
public class ConsultaRequest implements java.io.Serializable {

   @NotNull
    private String fecha;
   
   @NotEmpty
    private String descripcion;
   
    @NotEmpty
    private Integer estadoConsulta;
    
    @NotNull
    private Integer tipoConsulta;
    
    @NotNull
    private Float calificacion;
    
    @NotNull
    private Long personaId;
    
    @NotNull
    private Long doctorId;


}
