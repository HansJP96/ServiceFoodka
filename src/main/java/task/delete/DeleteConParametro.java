package task.delete;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;


import java.nio.charset.StandardCharsets;

public class DeleteConParametro implements Task {

    private String recursoWeb;
    private String parametro;
    private String valor;

    public static DeleteConParametro deleteConParametro() {
        return new DeleteConParametro();
    }

    public DeleteConParametro usandoElRecurso(String recursoWeb) {
        this.recursoWeb = recursoWeb;
        return this;
    }

    public DeleteConParametro setParametroYValor(String parametro, String valor) {
        this.parametro = parametro;
        this.valor = valor;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(recursoWeb).with(
                        requestSpecification ->
                                requestSpecification.pathParam(parametro, valor)
                                        .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                )
        );
    }

}
