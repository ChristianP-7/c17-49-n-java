package com.medilatam.backend.Service;

import com.medilatam.backend.Dto.DoctorDto;
import com.medilatam.backend.Entity.Doctor;
import com.medilatam.backend.Interface.IDoctorService;
import com.medilatam.backend.Repository.IConsultaRepository;
import com.medilatam.backend.Repository.IDoctorRepository;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.medilatam.backend.Utils.UtilMethods;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService implements IDoctorService {
    
    @Autowired IDoctorRepository idoctorrepository;
    private final IConsultaRepository consultaRepository;
    
    //Obtiene la lista de doctores
    @Override
    public List<Doctor> getDoctor() {
        return idoctorrepository.findAll();
    }

    //Guarda dentro de la lista el doctor nuevo
    @Override
    public void saveDoctor(Doctor doctor) {
        idoctorrepository.save(doctor);
    }

    //Elimina un Doctor según su ID
    @Override
    public void deleteDoctor(Long id) {
        idoctorrepository.deleteById(id);
    }

    //Devuelve un Doctor segun su ID
    @Override
    public Doctor getDoctor(Long id) {
       return idoctorrepository.findById(id).orElse(null);
    }

    //Devuelve a los doctores según su especialidad
    @Override
    public List<Doctor> findByEspecialidad(String especialidad) {
        return idoctorrepository.findByEspecialidad(especialidad);
    }

  // Trae los doctores que no tienen consulta en la fecha tentativa, uso Strings para que no se pierda el 0 en los meses y días y no cause conflictos con el formato de fecha
    public ResponseEntity<?> getEspecialidadesDisponibles(String dia, String mes) {
        
        Date fechaTentativa= UtilMethods.convertStringToSqlDate(Year.now()+"-" + mes +"-"+ dia);
        log.info("Fecha tentativa: {}", fechaTentativa);

        try {
            List<DoctorDto> disponibles = consultaRepository.findAll()// Obtiene todas las consultas agendadas para comparar con la fecha tentativa
                    .stream()
                    .filter(consulta -> consulta.getFecha().compareTo(fechaTentativa) != 0) // Compara la fecha tentativa con las fechas de las consultas ya agendadas, si es distinto 0
                    .map(consulta-> {
                        log.info("Fecha de la consulta: {}", consulta.getFecha());
                        Doctor doctor = consulta.getDoctor();
                        return DoctorDto.builder()
                                .nombre(doctor.getNombre())
                                .especialidad(doctor.getEspecialidad())
                                .horarioAtencion(doctor.getHorarioAtencion())
                                .localidad(doctor.getLocalidad())
                                /*.pais(doctor.getPais())*/
                                .telefono(String.valueOf(doctor.getTelefono()))//CORRECCIÓN
                                .costoConsulta(doctor.getCostoConsulta())
                                .build();
                    }).collect(Collectors.toList());
            return new ResponseEntity<>(disponibles, HttpStatus.OK);
        } catch (DataAccessException e) {
            return ResponseEntity.badRequest().body("Error al obtener los doctores disponibles");
        }
    }
    
}
