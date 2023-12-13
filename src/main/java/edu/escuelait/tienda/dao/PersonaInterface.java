package edu.escuelait.tienda.dao;

import edu.escuelait.tienda.model.Persona;
import edu.escuelait.tienda.requests.PersonaRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface PersonaInterface {
    public Persona findByLastName(String lastName);
    public List<Persona> findAll();
    public Persona findById(long id);

    public Persona create(@Valid PersonaRequest persona);
    public Persona update(@Valid PersonaRequest persona, long id);
    public boolean delete(Long id);
}
