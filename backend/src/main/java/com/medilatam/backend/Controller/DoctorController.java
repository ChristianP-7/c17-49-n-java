package com.medilatam.backend.Controller;

import com.medilatam.backend.Entity.Doctor;
// import com.medilatam.backend.Interface.IConsultaService;
import com.medilatam.backend.Interface.IDoctorService;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
@CrossOrigin(origins="*")
public class DoctorController {
    
    @Autowired
    IDoctorService idoctorservice;
    //private IConsultaService iConsultaService;
    
    //Obtener Doctores
    @GetMapping("/getDoctores")
    public List<Doctor> getDoctor(){
        return idoctorservice.getDoctor();
    }

    //Devuelve los datos de un usuario seleccionado por su ID
    @GetMapping("/getDoctores/{id}")
    public Doctor getDoctorById(@PathVariable(name = "id") Long id){
        return idoctorservice.getDoctor(id);
    }

    //Insertar Doctores en la lista
    @PostMapping("/createDoctor")
    public String createDoctor(@RequestBody @Valid Doctor doctor) {
        return idoctorservice.saveDoctor(doctor);
    }
    
    //Borrar Doctores
    @DeleteMapping("/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        idoctorservice.deleteDoctor(id);
        return "Success";
    }

    //Editar los Doctores
    @PutMapping("/updateDoctor/{id}")
    public Doctor updateDoctor(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("especialidad") String nuevoEspecialidad,
                               @RequestParam("horarioAtencion") String nuevoHorarioAtencion,
                               @RequestParam("localidad") String nuevoLocalidad,
                               @RequestParam("costoConsulta") Integer nuevoCostoConsulta
                               /*,@RequestParam("pais") String nuevoPais*/){
     Doctor doctor = idoctorservice.getDoctor(id);
     
     doctor.setNombre(nuevoNombre);
     doctor.setEspecialidad(nuevoEspecialidad);
     doctor.setHorarioAtencion(nuevoHorarioAtencion);
     doctor.setLocalidad(nuevoLocalidad);
     /*doctor.setPais(nuevoPais);*/
     doctor.setCostoConsulta(nuevoCostoConsulta);
     
     idoctorservice.saveDoctor(doctor);
     
     return doctor;
    }

    //Devuelve doctor por especialidad
    @GetMapping("findByEspecialidad/{especialidad}")
    public List<Doctor> findByEspecialidad(@PathVariable String especialidad){
        return idoctorservice.findByEspecialidad(especialidad);
    }
  
    // Retorna la lista de doctores que no tienen consulta en la fecha tentativa
    @GetMapping("doctor/getEspecialidadesDisponibles")
    public List<?> getEspecialidadesDisponibles(@RequestParam(name = "dia") String dia, @RequestParam(name = "mes") @NotNull String mes){
        return idoctorservice.getEspecialidadesDisponibles(dia, mes); 
    }
}
