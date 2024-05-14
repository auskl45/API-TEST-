package com.nttdata.step;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TiendaMascota {
    private String URLBASE;
    public void consultaMascota(int id) {
        SerenityRest.
                given()
                .baseUri(URLBASE)
                        .contentType("application/json")
                        .relaxedHTTPSValidation()
                        .when()
                .log()
                .all()
                        .get("/"+id)

                        .then()
                .log()
                .all();
    }

    public void setUrl(String url) {
        this.URLBASE = url;
    }

    public void validaRespuesta(int code) {
        Assert.assertEquals(code, lastResponse().getStatusCode());
    }

    public void validarNombreMascota(String nombreMascota) {
//Assert.assertEquals(nombreMascota, lastResponse().body().path("category.name"));
        Assert.assertEquals(nombreMascota, lastResponse().body().path("name").toString());


    }
    public void validoElParametroTengaElContenido(String parametro, String valor) {
        String resultadoEsperado=lastResponse().body().path(parametro).toString();
        Assert.assertEquals(valor,resultadoEsperado );

    }
}
