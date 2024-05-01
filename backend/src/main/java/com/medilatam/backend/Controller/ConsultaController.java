package com.medilatam.backend.Controller;


import com.medilatam.backend.Dto.ConsultaRequest;
import com.medilatam.backend.Entity.Consulta;
import com.medilatam.backend.Interface.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@CrossOrigin(origins="*")
public class ConsultaController {

    @Autowired
    IConsultaService iConsultaService;
    
    //Expone las consultas creadas
    @GetMapping("/getConsulta")
    public List<Consulta> getConsulta(){
        return iConsultaService.getConsulta();
    }

    // Expone las consultas creadas segun el ID del paciente
    @GetMapping("/getConsultas/{id}")
    public ResponseEntity<?> getConsultasByPacienteId(@PathVariable Long id){
        return iConsultaService.getConsultasByPacienteId(id);
    }

    @GetMapping("getConsultasByDoctorId/{id}")
    public ResponseEntity<?> getConsultasByDoctorId(@PathVariable Long id){
        return iConsultaService.getConsultasByDoctorId(id);
    }

    //TODO
    /*
     *
     * GetConsulta segun el estado de la consulta
     *
     * */

    
    //Crea una consulta
    @PostMapping("/createConsulta")
    public ResponseEntity<?> createConsulta(@RequestBody ConsultaRequest consulta){
        return iConsultaService.saveConsulta(consulta);
    }
    
    //Borra una consulta siguiendo su ID
    @DeleteMapping("/deleteConsulta/{id}")
    public ResponseEntity<?> deleteConsulta(@PathVariable Long id){
        return iConsultaService.deleteConsulta(id);
    }
    
    
    //Edita una consulta
    @PutMapping("/updateConsulta")
    public ResponseEntity<?> updateConsulta(@RequestParam(name = "id")  Long id,
                                            @RequestParam(name="descripcion") String nuevaDescripcion,
                                            @RequestParam(name = "estado") Integer nuevoEstadoDeConsulta,
                                            @RequestParam(name = "fecha") String nuevaFecha){
        
        //Retorna un status positivo si se realizó correctamente
        return iConsultaService.updateConsulta(id, nuevaDescripcion, nuevoEstadoDeConsulta, nuevaFecha);
    }

}
