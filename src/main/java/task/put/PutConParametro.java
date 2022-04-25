package task.put;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.nio.charset.StandardCharsets;

public class PutConParametro implements Task {

    private String recursoWeb;
    private String parametro;
    private String valor;

    public static PutConParametro putConParametro() {
        return new PutConParametro();
    }

    public PutConParametro usandoElRecurso(String recursoWeb) {
        this.recursoWeb = recursoWeb;
        return this;
    }

    public PutConParametro setParametroYValor(String parametro, String valor) {
        this.parametro = parametro;
        this.valor = valor;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(recursoWeb).with(
                        requestSpecification ->
                                requestSpecification.pathParam(parametro, valor)
                                        .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                )
        );
    }
}
