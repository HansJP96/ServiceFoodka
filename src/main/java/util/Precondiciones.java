package util;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import static util.GeneradorRandom.crearReservaRandom;

public class Precondiciones {

    public static Precondiciones precondiciones(){
        return new Precondiciones();
    }

    public void crearReservaExistente(String urlBase, String recursoWeb){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(crearReservaRandom())
                .post(urlBase.concat(recursoWeb));
    }

    public void traerReservaExistente(String urlBase, String recursoWeb, String id){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(crearReservaRandom())
                .get(urlBase.concat(recursoWeb),id);
    }
}
