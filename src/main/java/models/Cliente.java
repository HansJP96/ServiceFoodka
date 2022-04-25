package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({
        "apellido",
        "email",
        "nombre"
})
public class Cliente {

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("apellido")
    public String apellido;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("email")
    public String email;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("nombre")
    public String nombre;

}

