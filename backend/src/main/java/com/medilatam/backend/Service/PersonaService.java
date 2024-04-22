package com.medilatam.backend.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.medilatam.backend.Entity.PersonaEntity;
import com.medilatam.backend.Interface.IPersonaService;
import com.medilatam.backend.Repository.PersonaRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.io.IOException;
import java.util.Map;

@Service
public class PersonaService implements IPersonaService {

    private final Cloudinary cloudinary;

    public PersonaService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> listarPersonas() {
        List<PersonaEntity> personaEntities = personaRepository.findAll();
        return personaEntities;
    }

    @Override
    public PersonaEntity personaPorId(Long id) {
        PersonaEntity personaEntity = personaRepository.findById(id).orElse(null);
        return personaEntity;
    }

    @Override
    public void guardarPersona(PersonaEntity personaEntity, MultipartFile fileIcon) throws IOException {
        if (!fileIcon.isEmpty()) {
            if (fileIcon.getContentType().startsWith("image/")) {
                Map uploadResult = cloudinary.uploader().upload(fileIcon.getBytes(), ObjectUtils.emptyMap());
                personaEntity.setFoto(uploadResult.get("url").toString());
            } else {
                throw new IllegalArgumentException("El archivo debe ser una imagen.");
            }
        }
        personaEntity.setPassword(passwordEncoder.encode(personaEntity.getPassword()));
        personaRepository.save(personaEntity);
    }

    @Override
    public void actualizarPersonaPorId(Long id, PersonaEntity personaData, MultipartFile fileIcon) throws IOException {
        PersonaEntity personaEntity = personaRepository.findById(id).orElse(null);
        personaEntity.setName(personaData.getName());
        personaEntity.setEmail(personaData.getEmail());
        personaEntity.setPassword(passwordEncoder.encode(personaEntity.getPassword()));
        if (personaEntity.getFoto() != null) {
            String publicId = personaEntity.getFoto().substring(personaEntity.getFoto().lastIndexOf("/") + 1, personaEntity.getFoto().lastIndexOf("."));
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        }
        if (!fileIcon.isEmpty()) {
            if (fileIcon.getContentType().startsWith("image/")) {
                Map uploadResult = cloudinary.uploader().upload(fileIcon.getBytes(), ObjectUtils.emptyMap());
                personaEntity.setFoto(uploadResult.get("url").toString());
            } else {
                throw new IllegalArgumentException("El archivo debe ser una imagen.");
            }
        }
        personaRepository.save(personaEntity);
    }

    @Override
    public void eliminarPersonaPorId(Long id) throws IOException {
        PersonaEntity personaEntity = personaRepository.findById(id).orElse(null);
        if (personaEntity.getFoto() != null) {
            String publicId = personaEntity.getFoto().substring(personaEntity.getFoto().lastIndexOf("/") + 1, personaEntity.getFoto().lastIndexOf("."));
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        }
        personaRepository.deleteById(id);
    }

}
