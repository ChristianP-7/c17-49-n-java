package com.medilatam.backend.Interface;

import com.medilatam.backend.Entity.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Transactional
public interface IDoctorService {
    
    //Exponer Lista de Doctores
    public List<Doctor> getDoctor();
    
    //Guarda un Objeto que sea Doctor
    public void saveDoctor (Doctor doctor);
    
    //Eliminar un Objeto que sea Doctor
    public void deleteDoctor (Long id);
    
    //Buscar un Objeto del tipo Doctor por Id
    public Doctor findDoctor (Long id);

    // Obtener las especialidades disponibles en un dia y mes
    ResponseEntity<?> getEspecialidadesDisponibles(String dia, String mes);
}
