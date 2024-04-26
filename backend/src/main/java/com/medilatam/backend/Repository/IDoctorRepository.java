package com.medilatam.backend.Repository;

import com.medilatam.backend.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    //Busqueda con inversión de control
    List<Doctor> findByEspecialidad(String especialidad);
}
