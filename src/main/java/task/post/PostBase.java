package task.post;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;


import java.nio.charset.StandardCharsets;

public class PostBase implements Task {

    private String recursoWeb;


    public static PostBase putConParametro() {
        return new PostBase();
    }

    public PostBase usandoElRecurso(String recursoWeb) {
        this.recursoWeb = recursoWeb;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(recursoWeb).with(
                        requestSpecification ->
                                requestSpecification
                                        .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                )
        );
    }
}
