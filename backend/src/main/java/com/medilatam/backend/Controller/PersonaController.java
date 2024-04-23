package com.medilatam.backend.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medilatam.backend.Entity.PersonaEntity;
import com.medilatam.backend.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    IPersonaService iPersonaService;

    //Listado de usuarios
    @GetMapping("/getPersonas")
    public List<PersonaEntity> getPersonas(){
        return iPersonaService.getPersonas();
    }

    //Devuelve los datos de un usuario seleccionado por su ID
    @GetMapping("/getPersona/{id}")
    public PersonaEntity getPersonaById(@PathVariable(name = "id") Long id){
        return iPersonaService.getPersonaById(id);
    }

    //Crea un usuario
    @PostMapping("/createPersona")
    public ResponseEntity<?> createPersona(@RequestParam("data") String personaData, @RequestParam("fileIcon") MultipartFile fileIcon) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        PersonaEntity personaEntity = objectMapper.readValue(personaData, PersonaEntity.class);
        iPersonaService.savePersona(personaEntity, fileIcon);
        return ResponseEntity.status(HttpStatus.CREATED).body("El nuevo registro ha sido creado");
    }

    //Edita un usuario según su ID
    @PutMapping("/updatePersona/{id}")
    public ResponseEntity<?> updatePersonaById(@PathVariable(name = "id") Long id, @RequestParam("data") String personaData, @RequestParam("fileIcon") MultipartFile fileIcon) throws IOException {   
        ObjectMapper objectMapper = new ObjectMapper();
        PersonaEntity personaEntity = objectMapper.readValue(personaData, PersonaEntity.class);
        iPersonaService.updatePersonaById(id, personaEntity, fileIcon);
        return ResponseEntity.status(HttpStatus.OK).body("El registro ha sido actualizado con éxito.");
    }
    
    //Borra un usuario según su ID
    @DeleteMapping("/deletePersona/{id}")
    public ResponseEntity<?> deletePersonaById(@PathVariable(name = "id") Long id) throws IOException {   
        iPersonaService.deletePersonaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("El registro ha sido eliminado con éxito.");
    }

}
