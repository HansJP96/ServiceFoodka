package com.foodka.stepdefinitions.reservas;

import com.foodka.stepdefinitions.ConfigBase;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;

public class ObtenerReservaStepDefinition extends ConfigBase {

    private static final Logger LOGGER = Logger.getLogger(ObtenerReservaStepDefinition.class);

    @Dado("que accedo al recurso web de los servicios")
    public void queAccedoAlRecursoWebDeLosServicios() {

    }
    @Cuando("hago una peticion para consultar una reserva existente")
    public void hagoUnaPeticionParaConsultarUnaReservaExistente() {

    }
    @Entonces("recibo la informacion de la reserva")
    public void reciboLaInformacionDeLaReserva() {

    }

    @Cuando("hago una peticion para consultar una reserva inexistente")
    public void hagoUnaPeticionParaConsultarUnaReservaInexistente() {

    }
    @Entonces("no recibo informacion alguna y obtengo una respuesta acorde")
    public void noReciboInformacionAlgunaYObtengoUnaRespuestaAcorde() {

    }
}
