package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RespuestaListaHoras implements Question<String[]> {

    public static RespuestaListaHoras respuestaListaHoras() {
        return new RespuestaListaHoras();
    }
    @Override
    public String[] answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(String[].class);
    }
}
