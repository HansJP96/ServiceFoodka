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
import util.recursos.RecursosWebPost;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.notNullValue;
import static questions.RespuestaReserva.respuestaReserva;
import static questions.VerificarRespuestaHttp.verificarRespuestaHttp;
import static task.post.PostBase.postBase;
import static util.GeneradorRandom.crearReservaRandom;
import static util.Precondiciones.precondiciones;
import static util.recursos.RecursosWebPost.POST_CREAR_RESERVA;

public class CrearReservaStepDefinition extends ConfigBase {

    private final Actor actor = Actor.named("Comensal");
    private static final Logger LOGGER = Logger.getLogger(CrearReservaStepDefinition.class);

    @Dado("que accedo al recurso web de los servicios para crear reserva")
    public void queAccedoAlRecursoWebDeLosServiciosParaCrearReserva() {
        configGeneral();
        try {
            actor.whoCan(CallAnApi.at(SERVICIOS_BASE_FOODKA));
            LOGGER.info("Accediendo a la URI: ".concat(SERVICIOS_BASE_FOODKA));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia a: ".concat(SERVICIOS_BASE_FOODKA));
            Assertions.fail(exception);
        }

    }
    @Cuando("hago una peticion para crear una nueva reserva")
    public void hagoUnaPeticionParaCrearUnaNuevaReserva() {
        actor.attemptsTo(
                postBase().usandoElRecurso(POST_CREAR_RESERVA.obtenerValor()).setCuerpoPeticion(crearReservaRandom())
        );

    }
    @Entonces("observo que los datos de mi reserva han sido creados")
    public void observoQueLosDatosDeMiReservaHanSidoCreados() {
        verificarRespuestaHttp().setExpectedResponse(HttpStatus.SC_CREATED).answeredBy(actor);
        Reserva respuestaPost = respuestaReserva().answeredBy(actor);

        actor.should(seeThat("ver que el ID", actor1 -> respuestaPost.getId(), notNullValue() ) );



    }
}
