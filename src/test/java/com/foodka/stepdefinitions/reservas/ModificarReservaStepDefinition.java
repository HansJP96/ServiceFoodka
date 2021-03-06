package com.foodka.stepdefinitions.reservas;

import com.foodka.stepdefinitions.ConfigBase;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import models.Reserva;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import util.recursos.RecursosWebGet;
import util.recursos.RecursosWebPut;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.is;
import static questions.RespuestaReserva.respuestaReserva;
import static questions.RespuestaVacia.respuestaVacia;
import static questions.VerificarRespuestaHttp.verificarRespuestaHttp;
import static task.put.PutConParametro.putConParametro;
import static util.GeneradorRandom.*;
import static util.Precondiciones.precondiciones;

public class ModificarReservaStepDefinition extends ConfigBase {

    private final Actor actor = Actor.named("Comensal");
    private Reserva existente = new Reserva();
    private static final Logger LOGGER = Logger.getLogger(ModificarReservaStepDefinition.class);

    @Dado("que accedo al recurso web de los servicios para modificar")
    public void queAccedoAlRecursoWebDeLosServiciosParaModificar() {
        configGeneral();
        try {
            actor.whoCan(CallAnApi.at(SERVICIOS_BASE_FOODKA));
            LOGGER.info("Accediendo a la URI: ".concat(SERVICIOS_BASE_FOODKA));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia a: ".concat(SERVICIOS_BASE_FOODKA));
            Assertions.fail(exception);
        }
    }

    @Cuando("quiero modificar alguno de los datos de mi reserva")
    public void quieroModificarAlgunoDeLosDatosDeMiReserva() {
        try {
            precondiciones()
                    .traerReservaExistente(SERVICIOS_BASE_FOODKA, RecursosWebGet.GET_UNA_RESERVA.obtenerValor(), idDefinidoRandom());
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se obtenia - usuario existente");
            Assertions.fail(exception);
        }

        existente = SerenityRest.lastResponse().as(Reserva.class);
        LOGGER.info("Reserva existente en la base de datos: ".concat(existente.toJson()));

        existente.setMensaje(mensajeRandom());

        try {
            actor.attemptsTo(
                    putConParametro()
                            .usandoElRecurso(RecursosWebPut.PUT_MODIFICAR_RESERVA.obtenerValor())
                            .setParametroYValor("id", existente.getId())
                            .setCuerpoPeticion(existente.toJson())
            );
            LOGGER.info("PUT realizado con exito a: ".concat(RecursosWebPut.PUT_MODIFICAR_RESERVA
                    .reemplazarParametro(existente.getId())));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia al recurso web");
            Assertions.fail(exception);
        }

    }

    @Entonces("obtengo como respuesta mis datos actualizados")
    public void obtengoComoRespuestaMisDatosActualizados() {
        verificarRespuestaHttp().setExpectedResponse(HttpStatus.SC_OK).answeredBy(actor);
        Reserva respuestaPut = respuestaReserva().answeredBy(actor);

        actor.should(
                seeThat("el dia actualizado ", actor1 -> respuestaPut.getDia(), is(existente.getDia())),
                seeThat("la hora actualizado ", actor1 -> respuestaPut.getHora(), is(existente.getHora())),
                seeThat("el mensaje actualizado ", actor1 -> respuestaPut.getMensaje(), is(existente.getMensaje()))
        );
    }

    @Cuando("quiero modificar alguno de una reserva que no existe")
    public void quieroModificarAlgunoDeUnaReservaQueNoExiste() {
        String id = idRandom();
        String reserva = crearReservaRandom();
        try {
            actor.attemptsTo(
                    putConParametro()
                            .usandoElRecurso(RecursosWebPut.PUT_MODIFICAR_RESERVA.obtenerValor())
                            .setParametroYValor("id", id)
                            .setCuerpoPeticion(reserva)
            );
            LOGGER.info("PUT realizado con exito a: ".concat(RecursosWebPut.PUT_MODIFICAR_RESERVA
                    .reemplazarParametro(id)));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia al recurso web");
            Assertions.fail(exception);
        }
    }

    @Entonces("no obtengo informacion alguna actualizada")
    public void noObtengoInformacionAlgunaActualizada() {
        verificarRespuestaHttp().setExpectedResponse(HttpStatus.SC_NOT_FOUND).answeredBy(actor);

        respuestaVacia().answeredBy(actor);
        actor.should(
                seeThat(
                        "la respuesta es",
                        respuesta -> respuestaVacia().answeredBy(actor), is(true)
                )
        );
    }

}
