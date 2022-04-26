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
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import util.recursos.RecursosWebPost;
import util.recursos.RecursosWebPut;

import static task.get.GetConParametro.getConParametro;
import static util.GeneradorRandom.*;
import static util.Precondiciones.precondiciones;

public class ModificarReservaStepDefinition extends ConfigBase {

    private final Actor actor = Actor.named("Comensal");

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
            precondiciones().reservaExistente(SERVICIOS_BASE_FOODKA, RecursosWebPost.POST_CREAR_RESERVA.obtenerValor());
        } catch (Exception exception){
            LOGGER.error("Ocurrio un error mientras se creaba - usuario existente");
            Assertions.fail(exception);
        }

        Reserva existente = SerenityRest.lastResponse().as(Reserva.class);
        LOGGER.info("Reserva existente en la base de datos: ".concat(existente.toJson()));

        existente.setDia(diaRandom());
        existente.setHora(horaRandom());
        existente.setMensaje(mensajeRandom());

        try {
            actor.attemptsTo(
                    getConParametro()
                            .usandoElRecurso(RecursosWebPut.PUT_MODIFICAR_RESERVA.obtenerValor())
                            .setParametroYValor("id", existente.getId())
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

    }

    @Cuando("quiero modificar alguno de una reserva que no existe")
    public void quieroModificarAlgunoDeUnaReservaQueNoExiste() {

    }
    @Entonces("no obtengo informacion alguna actualizada")
    public void noObtengoInformacionAlgunaActualizada() {

    }

}
