package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({
        "apellido",
        "email",
        "nombre",
        "telefono"
})
public class Cliente {

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("apellido")
    private String apellido;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("email")
    private String email;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("nombre")
    private String nombre;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

