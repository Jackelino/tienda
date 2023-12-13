package edu.escuelait.tienda.services;

import edu.escuelait.tienda.entities.PersonaEntity;
import edu.escuelait.tienda.model.Persona;
import edu.escuelait.tienda.dao.PersonaInterface;
import edu.escuelait.tienda.repositories.PersonaRepository;
import edu.escuelait.tienda.requests.PersonaRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.LinkedList;
import java.util.List;


@Service
@Validated
public class PersonaService implements PersonaInterface {
    private final PersonaRepository personaRepository;
    private final ModelMapper modelMapper;

    public PersonaService(PersonaRepository personaRepository, ModelMapper modelMapper) {
        this.personaRepository = personaRepository;
        this.modelMapper = modelMapper;
    }

    public Persona findByLastName(String lastName) {

        PersonaEntity persona = this.personaRepository.findByLastName(lastName);
        return modelMapper.map(persona, Persona.class);
    }

    @Override
    public List<Persona> findAll() {
        List<PersonaEntity> personas = this.personaRepository.findAll();
        List<Persona> personas1 = new LinkedList<>();
        for (PersonaEntity PE : personas) {
            personas1.add(modelMapper.map(PE, Persona.class));
        }
        return personas1;
    }

    @Override
    public Persona findById(long id) {
        PersonaEntity persona = this.personaRepository.findById(id);
        return modelMapper.map(persona, Persona.class);
    }

    @Override
    public Persona create(PersonaRequest personaRequest) {
        PersonaEntity personaEntity = null;
        personaEntity = this.personaRepository.save(modelMapper.map(personaRequest, PersonaEntity.class));
        return modelMapper.map(personaEntity, Persona.class);
    }

    @Override
    public Persona update(PersonaRequest personaRequest, long id) {
        PersonaEntity personaEntity = this.personaRepository.findById(id);
        personaEntity.setName(personaRequest.getName());
        personaEntity.setLastName(personaRequest.getLastName());

        personaEntity = this.personaRepository.save(modelMapper.map(personaEntity, PersonaEntity.class));
        return modelMapper.map(personaEntity, Persona.class);
    }

    @Override
    public boolean delete(Long id) {
        boolean flagDelete = false;
        try {
            this.personaRepository.deleteById(id);
            flagDelete = true;
        } catch (Exception ignored) {
            return flagDelete;
        }
        return flagDelete;
    }

    /*
    private Persona convertToPersona(final PersonaEntity personaEntity) {
        return this.modelMapper.map(personaEntity, Persona.class);
    }*/
}
