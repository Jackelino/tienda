package edu.escuelait.tienda.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class PersonaRequest implements Serializable {

    @JsonProperty("name")
    @NotBlank
    private String name;
    @NotBlank
    @JsonProperty("lastName")
    private String lastName;
}
