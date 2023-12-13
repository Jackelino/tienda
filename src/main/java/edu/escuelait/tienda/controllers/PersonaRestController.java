package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.model.Persona;
import edu.escuelait.tienda.exceptions.ResourceNotFoundException;
import edu.escuelait.tienda.dao.PersonaInterface;
import edu.escuelait.tienda.requests.PersonaRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonaRestController {
    private PersonaInterface personService; // una interfaz para desacoplar la rigidez que ayude a

    public PersonaRestController(PersonaInterface personService) {
        this.personService = personService;
    }


    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        if (this.personService.findById(id) != null) {
            return ResponseEntity.ok(this.personService.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    /*
    @GetMapping("/personas/{lastName}")
    public ResponseEntity<Persona> getByLastName(@PathVariable String lastName){
        return ResponseEntity.ok(this.personService.findByLastName(lastName));
    }*/
    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> listPersonas() {
        return ResponseEntity.ok(this.personService.findAll());
    }

    @PostMapping("/personas")
    public ResponseEntity createPersona(@Valid @RequestBody PersonaRequest personaRequest, BindingResult result) {
        ResponseEntity<?> errores = getResponseEntity(result);
        if (errores != null) return errores;
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/personas/{persona}")
                .buildAndExpand(personaRequest.getName()) // getId porque temos un metodo que busca ala persona por id; "getPersonaById"
                .toUri();
        /**
         * recupera la ruta actual,
         */
        this.personService.create(personaRequest);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<?> updatePersona(@Valid @RequestBody PersonaRequest personaRequest, @PathVariable Long id, BindingResult result) {
        ResponseEntity<?> errores = getResponseEntity(result);
        if (errores != null) return errores;
        Persona personaCreate = null;
        personaCreate = this.personService.update(personaRequest, id);
        if (personaCreate != null) {
            return ResponseEntity.ok(personaCreate);
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> getResponseEntity(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        }
        return null;
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity deletePersona(@PathVariable Long id) {
        if (this.personService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
