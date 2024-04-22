package com.medilatam.backend.Service;

import com.medilatam.backend.Entity.Doctor;
import com.medilatam.backend.Interface.IDoctorService;
import com.medilatam.backend.Repository.IDoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements IDoctorService {
    
    @Autowired IDoctorRepository idoctorrepository;
    
    //Obtiene la lista de doctores
    @Override
    public List<Doctor> getDoctor() {
        List<Doctor> doctor = idoctorrepository.findAll();
        return doctor;
    }

    //Guarda dentro de la lista el doctor nuevo
    @Override
    public void saveDoctor(Doctor doctor) {
        idoctorrepository.save(doctor);
    }

    
    
    @Override
    public void deleteDoctor(Long id) {
        idoctorrepository.deleteById(id);
    }

    @Override
    public Doctor findDoctor(Long id) {
        Doctor doctor = idoctorrepository.findById(id).orElse(null);
        return doctor;
    }

    @Override
    public List<Doctor> findByEspecialidad(String especialidad) {
        return idoctorrepository.findByEspecialidad(especialidad);
    }


}
