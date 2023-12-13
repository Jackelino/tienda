package edu.escuelait.tienda.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRestController {
    @GetMapping("/saludo")
    public String holaMundo(){

        return "Hola mundo spring ";
    }

    @GetMapping("/saludo/{user}")
    public String holaMundoUser(@PathVariable String user){
        return "Hola mundo spring, " + user ;
    }
}
