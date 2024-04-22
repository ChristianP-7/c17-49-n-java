package com.medilatam.backend.Controller;

import com.medilatam.backend.Entity.Doctor;
// import com.medilatam.backend.Interface.IConsultaService;
import com.medilatam.backend.Interface.IDoctorService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {
    
    @Autowired
    IDoctorService idoctorservice;
    //private IConsultaService iConsultaService;

    
    //Obtener Doctores
    @GetMapping("/showDoctores")
    public List<Doctor> getDoctor(){
        return idoctorservice.getDoctor();
    }


    //Devuelve los datos de un usuario seleccionado por su ID
    @GetMapping("/showDoctores/{id}")
    public Doctor getDoctorById(@PathVariable(name = "id") Long id){
        return idoctorservice.findDoctor(id);
    }


    //Insertar Doctores en la lista
    @PostMapping("/createDoctor")
    public String createDoctor(@RequestBody Doctor doctor) {
        idoctorservice.saveDoctor(doctor);
        return "Success";
    }
    
    //Borrar Doctores
    @DeleteMapping("/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        idoctorservice.deleteDoctor(id);
        return "Success";
    }
    
    //Editar los Doctores
    @PutMapping("/editDoctor/{id}")
    public Doctor editDoctor (@PathVariable Long id,
                                            @RequestParam("nombre") String nuevoNombre,
                                            @RequestParam("especialidad") String nuevoEspecialidad,
                                            @RequestParam("horarioAtencion") String nuevoHorarioAtencion,
                                            @RequestParam("localidad") String nuevoLocalidad,
                                            @RequestParam("costoConsulta") Integer nuevoCostoConsulta) {
     Doctor doctor = idoctorservice.findDoctor(id);
     
     doctor.setNombre(nuevoNombre);
     doctor.setEspecialidad(nuevoEspecialidad);
     doctor.setHorarioAtencion(nuevoHorarioAtencion);
     doctor.setLocalidad(nuevoLocalidad);
     doctor.setCostoConsulta(nuevoCostoConsulta);
     
     idoctorservice.saveDoctor(doctor);
     
     return doctor;
    }

    //Devuelve doctor por especialidad
    @GetMapping("findByEspecialidad/{especialidad}")
    public List<Doctor> findByEspecialidad(@PathVariable String especialidad){
        return idoctorservice.findByEspecialidad(especialidad);
    }

}
