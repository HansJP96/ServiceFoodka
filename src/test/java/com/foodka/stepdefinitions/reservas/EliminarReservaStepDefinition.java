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
import util.recursos.RecursosWebDelete;
import util.recursos.RecursosWebPost;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static questions.RespuestaReserva.respuestaReserva;
import static questions.RespuestaVacia.respuestaVacia;
import static questions.VerificarRespuestaHttp.verificarRespuestaHttp;
import static task.delete.DeleteConParametro.deleteConParametro;
import static util.GeneradorRandom.idRandom;
import static util.Precondiciones.precondiciones;

public class EliminarReservaStepDefinition extends ConfigBase {
    private final Actor actor = Actor.named("Comensal");
    private static final Logger LOGGER = Logger.getLogger(EliminarReservaStepDefinition.class);

    @Dado("que accedo al recurso web de los servicios para eliminar")
    public void queAccedoAlRecursoWebDeLosServiciosParaEliminar() {
        configGeneral();
        try {
            actor.whoCan(CallAnApi.at(SERVICIOS_BASE_FOODKA));
            LOGGER.info("Accediendo a la URI: ".concat(SERVICIOS_BASE_FOODKA));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia a: ".concat(SERVICIOS_BASE_FOODKA));
            Assertions.fail(exception);
        }
    }
    @Cuando("hago una peticion para cancelar una reserva")
    public void hagoUnaPeticionParaCancelarUnaReserva() {
        try {
            precondiciones()
                    .crearReservaExistente(SERVICIOS_BASE_FOODKA, RecursosWebPost.POST_CREAR_RESERVA.obtenerValor());
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se creaba - usuario existente");
            Assertions.fail(exception);
        }

        Reserva existente = SerenityRest.lastResponse().as(Reserva.class);
        LOGGER.info("Reserva existente en la base de datos: ".concat(existente.toJson()));
        try {
            actor.attemptsTo(
                    deleteConParametro()
                            .usandoElRecurso(RecursosWebDelete.DELETE_RESERVA.obtenerValor())
                            .setParametroYValor("id", existente.getId())
            );
            LOGGER.info("DELETE realizado con exito a: ".concat(RecursosWebDelete.DELETE_RESERVA
                    .reemplazarParametro(existente.getId())));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia al recurso web");
            Assertions.fail(exception);
        }
    }
    @Entonces("observo que mi reserva ha sido eliminada")
    public void observoQueMiReservaHaSidoEliminada() {
        verificarRespuestaHttp().setExpectedResponse(HttpStatus.SC_OK).answeredBy(actor);
        Reserva respuestaDelete = respuestaReserva().answeredBy(actor);
        actor.should(seeThat("ver que el ID", actor1 -> respuestaDelete.getId(), notNullValue() ) );

    }

    @Cuando("hago una peticion para cancelar una reserva que no existe")
    public void hagoUnaPeticionParaCancelarUnaReservaQueNoExiste() {

        String idInexistente = idRandom();
        try {
            actor.attemptsTo(
                    deleteConParametro()
                            .usandoElRecurso(RecursosWebDelete.DELETE_RESERVA.obtenerValor())
                            .setParametroYValor("id", idInexistente)
            );
            LOGGER.info("DELETE realizado con exito a: ".concat(RecursosWebDelete.DELETE_RESERVA
                    .reemplazarParametro(idInexistente)));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia al recurso web");
            Assertions.fail(exception);
        }


    }
    @Entonces("no observo ningun cambio y obtengo una respuesta acorde")
    public void noObservoNingunCambioYObtengoUnaRespuestaAcorde() {
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




