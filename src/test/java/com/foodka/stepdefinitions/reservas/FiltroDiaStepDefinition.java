package com.foodka.stepdefinitions.reservas;

import com.foodka.stepdefinitions.ConfigBase;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import util.recursos.RecursosWebGet;

import java.util.Arrays;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.matchesPattern;
import static questions.RespuestaListaHoras.respuestaListaHoras;
import static questions.VerificarRespuestaHttp.verificarRespuestaHttp;
import static task.get.GetConParametro.getConParametro;
import static util.GeneradorRandom.diaDefinidoRandom;

public class FiltroDiaStepDefinition extends ConfigBase {
    private final Actor actor = Actor.named("Comensal");
    private static final Logger LOGGER = Logger.getLogger(FiltroDiaStepDefinition.class);

    @Dado("que accede al recurso web que proporciona las horas ocupadas")
    public void queAccedeAlRecursoWebQueProporcionaLasHorasOcupadas() {
        configGeneral();
        try {
            actor.whoCan(CallAnApi.at(SERVICIOS_BASE_FOODKA));
            LOGGER.info("Accediendo a la URI: ".concat(SERVICIOS_BASE_FOODKA));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia a: ".concat(SERVICIOS_BASE_FOODKA));
            Assertions.fail(exception);
        }
    }

    @Cuando("realizo la peticion para escoger la hora de un dia seleccionado")
    public void realizoLaPeticionParaEscogerLaHoraDeUnDiaSeleccionado() {
        String diaExistente = diaDefinidoRandom();
        LOGGER.info("Reserva existente con fecha en la base de datos: ".concat(diaExistente));
        try {
            actor.attemptsTo(
                    getConParametro()
                            .usandoElRecurso(RecursosWebGet.GET_HORAS_DIA.obtenerValor())
                            .setParametroYValor("dia", diaExistente)
            );
            LOGGER.info("GET realizado con exito a: ".concat(RecursosWebGet.GET_HORAS_DIA
                    .reemplazarParametro(diaExistente)));
        } catch (Exception exception) {
            LOGGER.error("Ocurrio un error mientras se accedia al recurso web");
            Assertions.fail(exception);
        }
    }

    @Entonces("observo que existen horarios seleccionados para ese dia")
    public void observoQueExistenHorariosSeleccionadosParaEseDia() {
        verificarRespuestaHttp().setExpectedResponse(HttpStatus.SC_OK).answeredBy(actor);
        String[] respuesta = respuestaListaHoras().answeredBy(actor);

        actor.should(
                seeThat("la respueste contiene un lista de horas permitidas",
                        response -> Arrays.stream(respuesta).collect(Collectors.toList()), everyItem(matchesPattern("\\d{2}:\\d{2}"))  )
        );
    }}
