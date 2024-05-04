package com.medilatam.backend.Interface;

import org.springframework.web.multipart.MultipartFile;
import com.medilatam.backend.Entity.PersonaEntity;

import java.io.IOException;
import java.util.List;

public interface IPersonaService {

    //Lista los usuarios
    List<PersonaEntity> getPersonas();

    //Muestra un usuario según el ID
    PersonaEntity getPersonaById(Long id);

    //Almacena un nuevo usuario
    String savePersona(PersonaEntity personaEntity, MultipartFile fileIcon) throws IOException;

    //Edita un usuario basandose en su ID
    void updatePersonaById(Long id, PersonaEntity personaEntity, MultipartFile fileIcon) throws IOException;

    //Elimina un usuario buscandolo por su ID
    void deletePersonaById(Long id) throws IOException;

}
