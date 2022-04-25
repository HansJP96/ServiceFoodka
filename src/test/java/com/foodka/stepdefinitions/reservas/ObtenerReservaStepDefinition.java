package com.foodka.stepdefinitions.reservas;

import com.foodka.stepdefinitions.ConfigBase;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.http.ContentType;
import models.Reserva;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import util.recursos.RecursosWebGet;
import util.recursos.RecursosWebPost;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static questions.RespuestaReserva.respuestaReserva;
import static questions.RespuestaVacia.respuestaVacia;
import static questions.VerificarRespuestaHttp.verificarRespuestaHttp;
import static task.get.GetConParametro.getConParametro;
import static util.GeneradorRandom.idRandom;
import static util.GeneradorRandom.crearReservaRandom;

public class ObtenerReservaStepDefinition extends ConfigBase {

    private final Actor actor = Actor.named("Comensal");

    private static final Logger LOGGER = Logger.getLogger(ObtenerReservaStepDefinition.class);

    @Dado("que accedo al recurso web de los servicios para obtener reserva")
    public void queAccedoAlRecursoWebDeLosServiciosParaObtenerReserva() {
        configGeneral();
        try {
            actor.whoCan(CallAnApi.at(SERVICIOS_BASE_FOODKA));
            LOGGER.info("Accediendo a la URI: ".concat(SERVICIOS_BASE_FOODKA));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia a: ".concat(SERVICIOS_BASE_FOODKA));
            Assertions.fail(exception);
        }
    }

    @Cuando("hago una peticion para consultar una reserva existente")
    public void hagoUnaPeticionParaConsultarUnaReservaExistente() {
        try {
            SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(crearReservaRandom())
                    .post(SERVICIOS_BASE_FOODKA.concat(RecursosWebPost.POST_CREAR_RESERVA.obtenerValor()));
        } catch (Exception exception){
            LOGGER.error("Ocurrio un error mientras se creaba - usuario existente");
            Assertions.fail(exception);
        }
        

        Reserva existente = SerenityRest.lastResponse().as(Reserva.class);
        LOGGER.info("Reserva existente en la base de datos: ".concat(existente.toJson()));
        try {
            actor.attemptsTo(
                    getConParametro()
                            .usandoElRecurso(RecursosWebGet.GET_UNA_RESERVA.obtenerValor())
                            .setParametroYValor("id", existente.getId())
            );
            LOGGER.info("GET realizado con exito a: ".concat(RecursosWebGet.GET_UNA_RESERVA
                    .reemplazarParametro(existente.getId())));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia al recurso web");
            Assertions.fail(exception);
        }
    }

    @Entonces("recibo la informacion de la reserva")
    public void reciboLaInformacionDeLaReserva() {
        verificarRespuestaHttp().setExpectedResponse(HttpStatus.SC_OK).answeredBy(actor);
        Reserva respuestaGet = respuestaReserva().answeredBy(actor);

        actor.should(
                seeThat("la informacion devuelta",
                        response -> respuestaGet,
                        allOf(
                                hasProperty("cliente"),
                                hasProperty("hora"),
                                hasProperty("dia"),
                                hasProperty("id"),
                                hasProperty("mensaje")
                        )
                )
        );
    }

    @Cuando("hago una peticion para consultar una reserva inexistente")
    public void hagoUnaPeticionParaConsultarUnaReservaInexistente() {
        String idInexistente = idRandom();
        try {
            actor.attemptsTo(
                    getConParametro()
                            .usandoElRecurso(RecursosWebGet.GET_UNA_RESERVA.obtenerValor())
                            .setParametroYValor("id", idInexistente)
            );
            LOGGER.info("GET realizado con exito a: ".concat(RecursosWebGet.GET_UNA_RESERVA
                    .reemplazarParametro(idInexistente)));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia al recurso web");
            Assertions.fail(exception);
        }
    }

    @Entonces("no recibo informacion alguna y obtengo una respuesta acorde")
    public void noReciboInformacionAlgunaYObtengoUnaRespuestaAcorde() {
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
