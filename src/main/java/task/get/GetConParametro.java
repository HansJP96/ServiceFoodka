package task.get;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.nio.charset.StandardCharsets;

public class GetConParametro implements Task {

    private String recursoWeb;
    private String parametro;
    private String valor;

    public static GetConParametro getConParametro() {
        return new GetConParametro();
    }

    public GetConParametro usandoElRecurso(String recursoWeb) {
        this.recursoWeb = recursoWeb;
        return this;
    }

    public GetConParametro setParametroYValor(String parametro, String valor) {
        this.parametro = parametro;
        this.valor = valor;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(recursoWeb).with(
                        requestSpecification ->
                                requestSpecification.pathParam(parametro, valor)
                                        .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                )
        );
    }

}
