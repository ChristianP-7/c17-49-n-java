package com.medilatam.backend.Repository;

import com.medilatam.backend.Entity.Consulta;
import com.medilatam.backend.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta,Long> {

    // Valida si existe una consulta en la fecha y doctor especificado para evitar duplicados
    boolean existsByFechaAndDoctor(Date fecha, Doctor doctor);


}
