package questions;

import models.Reserva;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RespuestaReserva implements Question<Reserva> {
    public static RespuestaReserva respuestaReserva() {
        return new RespuestaReserva();
    }

    @Override
    public Reserva answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Reserva.class);
    }
}
