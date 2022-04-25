package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RespuestaVacia implements Question<Boolean> {

    public static RespuestaVacia respuestaVacia() {
        return new RespuestaVacia();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().asString().isEmpty();
    }
}
