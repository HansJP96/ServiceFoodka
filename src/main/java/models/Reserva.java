package models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({
        "cliente",
        "dia",
        "hora",
        "id",
        "mensaje"
})
public class Reserva {
    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("cliente")
    public Cliente cliente;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("dia")
    public String dia;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("hora")
    public String hora;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("id")
    public String id;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("mensaje")
    public String mensaje;
}
