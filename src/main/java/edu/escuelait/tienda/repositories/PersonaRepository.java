package edu.escuelait.tienda.repositories;

import edu.escuelait.tienda.entities.PersonaEntity;
import edu.escuelait.tienda.model.Persona;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaEntity, Long> {

    @Override
    List<PersonaEntity> findAll();
    @Transactional()
    PersonaEntity findByLastName(String lastName);
    PersonaEntity findById(long id);

    @Override
    PersonaEntity save(PersonaEntity personaEntity);

}
