package edu.escuelait.tienda.model;

import lombok.*;

import java.io.Serializable;

/**
 * lombok.Data: me genera automaticamente los
 * getters y setters de los atributos de clase
 */
@Data
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class Persona implements Serializable {
    /**
     * Java POJO
     */
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;
}
