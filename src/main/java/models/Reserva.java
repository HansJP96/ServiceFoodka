package models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import util.ConvertidorJson;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({
        "cliente",
        "dia",
        "hora",
        "id",
        "mensaje",
        "cantidadPersonas"
})
public class Reserva extends ConvertidorJson {

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("cliente")
    private Cliente cliente;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("dia")
    private String dia;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("hora")
    private String hora;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("id")
    private String id;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("mensaje")
    private String mensaje;

    @JsonInclude(Include.NON_DEFAULT)
    @JsonProperty("cantidadPersonas")
    private String cantidadPersonas;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(String cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
