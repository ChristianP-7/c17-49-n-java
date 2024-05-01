package com.medilatam.backend.Service;

import com.medilatam.backend.Dto.ConsultaDto;
import com.medilatam.backend.Dto.ConsultaRequest;
import com.medilatam.backend.Entity.Consulta;
import com.medilatam.backend.Entity.TipoConsulta;
import com.medilatam.backend.Security.Enums.EstadoConsulta;
import com.medilatam.backend.Interface.IConsultaService;
import com.medilatam.backend.Repository.IConsultaRepository;
import com.medilatam.backend.Repository.IDoctorRepository;
import com.medilatam.backend.Repository.PersonaRepository;
import com.medilatam.backend.Utils.UtilMethods;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

@Slf4j
public class ConsultaService implements IConsultaService {
    
    @Autowired
    IConsultaRepository consultaRepository;
    
    private final PersonaRepository personaRepository;
    private final IDoctorRepository doctorRepository;
    
    //Obtiene una lista de las consultas
    @Override
    public List<Consulta> getConsulta() {
        
        //Crea una lista según las consultas que se hayan guardado
        return consultaRepository.findAll();

    }

    //Guarda la consulta dentro del repositorio de consultas
    @Override
    public ResponseEntity<?> saveConsulta(ConsultaRequest consulta) {

        Date fechaRecibida= UtilMethods.convertStringToSqlDate(consulta.getFecha());

        // Verifica si ya existe una consulta con la misma fecha y el mismo doctor
        if(consultaRepository.existsByFechaAndDoctor(fechaRecibida
                , doctorRepository.findById(consulta.getDoctorId()).orElse(null))){
            return ResponseEntity.status(400).body("Ya existe una consulta en esa fecha y con ese doctor");
        }

        //Crea una consulta con los datos recibidos
        Consulta consulta1 = Consulta.builder()
                .fecha(fechaRecibida)
                .descripcion(consulta.getDescripcion())
                .estado(UtilMethods.setEstadoConsulta(consulta.getEstadoConsulta()))
                .tipo(UtilMethods.setTipoConsulta(consulta.getTipoConsulta()))
                .calificacion(consulta.getCalificacion())
                .especialidad(doctorRepository.findById(consulta.getDoctorId()).orElse(null).getEspecialidad() )
                .paciente(personaRepository.findById(consulta.getPersonaId()).orElse(null))
                .doctor(doctorRepository.findById(consulta.getDoctorId()).orElse(null))
                .precio(Float
                        .valueOf(doctorRepository.findById(consulta.getDoctorId()).orElse(null)
                                .getCostoConsulta()))
                .build();
        
        //Guarda la consulta dentro del repositorio de consultas
        consultaRepository.save(consulta1);
        return ResponseEntity.status(200).body("Consulta guardada con éxito");
    }

    
    //Según el ID dado se busca dicha consulta para eliminarla
    @Override
    public ResponseEntity<?> deleteConsulta(Long id) {
        
        //Si no existe la consulta con el ID dado
        if (!consultaRepository.existsById(id)) {
            return ResponseEntity.status(400).body("La consulta no existe");
        }
        
        //Se elimina una consulta en particular del repositorio designada por su ID
        consultaRepository.deleteById(id);
        return ResponseEntity.status(200).body("Consulta eliminada con éxito");
        
    }

    
    //Busca una consulta según un ID dado
    @Override
    public ResponseEntity<?> findConsulta(Long id) {
        //Si no existe la consulta con el ID dado
        if (!consultaRepository.existsById(id)) {
            return ResponseEntity.status(400).body("La consulta no existe");
        }
        //Se busca una consulta por su ID para guardarla dentro de la variable y si no la encuentra expone un null
        Consulta consulta = consultaRepository.findById(id).orElse(null);
        
        //Se expone la variable que posee la consulta buscada
        return ResponseEntity.status(200).body(consulta);
    }

    @Override
    public ResponseEntity<?> getConsultasNoAtendidas() {
         //Obtiene todas las consultas no atendidas
        List<Consulta> consultasNoAtendidas = consultaRepository.findAll()
                .stream()
                .filter(consulta->
                        consulta.getEstado().equals(EstadoConsulta.NO_ATENDIDO)).toList();
        return ResponseEntity.status(200).body(consultasNoAtendidas);
    }

    @Override
    public ResponseEntity<?> updateConsulta(Long id, String nuevaDescripcion, Integer nuevoEstadoDeConsulta, String nuevaFecha) {
        //Si no existe la consulta con el ID dado
        if (!consultaRepository.existsById(id)) {
            return ResponseEntity.status(400).body("La consulta no existe");
        }
        Consulta consulta = consultaRepository.findById(id).get();
        consulta.setDescripcion(nuevaDescripcion);
        consulta.setEstado(UtilMethods.setEstadoConsulta(nuevoEstadoDeConsulta));
        consulta.setFecha(UtilMethods.convertStringToSqlDate(nuevaFecha));
        consultaRepository.save(consulta);
        return ResponseEntity.status(200).body("Consulta editada con éxito");
    }

    @Override
    public ResponseEntity<?> getConsultasByPacienteId(Long id) {
        if(!personaRepository.existsById(id)){
            return ResponseEntity.status(400).body("El usuario no existe");
        }
        List<ConsultaDto> consultasIdPaciente= consultaRepository.findAll()
                .stream()
                .filter(consulta-> Objects.equals(consulta.getPaciente().getId(), id))
                .map(consultaId -> new ConsultaDto().builder()
                        .tipoConsulta(consultaId.getTipo())
                        .descripcion(consultaId.getDescripcion())
                        .estadoConsulta(consultaId.getEstado())
                        .fecha(consultaId.getFecha())
                        .doctor(consultaId.getDoctor())
                        .persona(consultaId.getPaciente())
                        .build())
                .toList();
        return ResponseEntity.status(200).body(consultasIdPaciente);

    }

    @Override
    public ResponseEntity<?> getConsultasByDoctorId(Long id) {
        if(!personaRepository.existsById(id)) {
            return ResponseEntity.status(400).body("El doctor no existe");
        }
        List<ConsultaDto> consultasIdDoctor = consultaRepository.findAll()
                .stream()
                .filter(consulta -> Objects.equals(consulta.getDoctor().getId(), id))
                .map(consultaId -> new ConsultaDto().builder()
                        .tipoConsulta(consultaId.getTipo())
                        .descripcion(consultaId.getDescripcion())
                        .estadoConsulta(consultaId.getEstado())
                        .fecha(consultaId.getFecha())
                        .doctor(consultaId.getDoctor())
                        .persona(consultaId.getPaciente())
                        .build())
                .toList();
        return ResponseEntity.ok().body(consultasIdDoctor);
    }
}
