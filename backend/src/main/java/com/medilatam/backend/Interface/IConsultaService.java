package com.medilatam.backend.Interface;

import com.medilatam.backend.Dto.ConsultaRequest;
import com.medilatam.backend.Entity.Consulta;
import com.medilatam.backend.Security.Enums.EstadoConsulta;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IConsultaService {
    
    //Expone la lista de Consultas
    List<Consulta> getConsulta();
    
    //Guarda una consulta
    ResponseEntity<?> saveConsulta(ConsultaRequest consulta);
    
    //Eliminar una consulta por ID
    ResponseEntity<?> deleteConsulta(Long id);
    
    //Buscar una consulta por ID
    ResponseEntity<?> findConsulta(Long id);

    //Busca consultas no atendidas por id - REVISION
    ResponseEntity<?> getConsultasNoAtendidas();

    //Edita una consulta siendo esta identificada por su id
    ResponseEntity<?> updateConsulta(Long id, String nuevaDescripcion, Integer nuevoEstadoDeConsulta, String nuevaFecha);

    ResponseEntity<?> getConsultasByPacienteId(Long id);

    // Expone la lista de Consultas filtradas por estado
    ResponseEntity<?> getConsultasByEstado(EstadoConsulta estado);
}
