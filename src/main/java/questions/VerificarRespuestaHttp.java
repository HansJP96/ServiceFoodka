package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.log4j.Logger;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class VerificarRespuestaHttp implements Question<Void> {
    private int expectedStatusCode;
    private static final Logger LOGGER = Logger.getLogger(VerificarRespuestaHttp.class);

    public static VerificarRespuestaHttp checkHttpResponse() {
        return new VerificarRespuestaHttp();
    }

    public VerificarRespuestaHttp setExpectedResponse(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
        return this;
    }

    @Override
    public Void answeredBy(Actor actor) {
        LOGGER.info("Cuerpo de Respuesta:\n");
        LastResponse.received().answeredBy(actor).prettyPrint();
        actor.should(
                seeThatResponse("Codigo de respuesta debe ser: " + expectedStatusCode,
                        validateResponse -> validateResponse.statusCode(expectedStatusCode)
                )
        );
        return null;
    }
}
