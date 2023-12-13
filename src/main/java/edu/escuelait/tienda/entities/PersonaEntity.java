package edu.escuelait.tienda.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Data
@Entity()
@Table(name = "personas")
@RequestMapping("/")
public class PersonaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
}
