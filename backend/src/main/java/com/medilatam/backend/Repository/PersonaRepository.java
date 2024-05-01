package com.medilatam.backend.Repository;
import com.medilatam.backend.Entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonaRepository extends
        JpaRepository<PersonaEntity, Long>,
        JpaSpecificationExecutor<PersonaEntity> {
}
