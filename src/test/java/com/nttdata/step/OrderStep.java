package com.nttdata.step;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class OrderStep {
    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";
    private String URLBASE;

    public void crearOrden(int idOrder, int petId, int cantidad) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \""+idOrder+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+cantidad+"\"\n" +
                        "}")
                //log del request .log().all()
                //logs del response
                .post(CREATE_ORDER)
                .then()
                .log()
                .all();
    }

    public void setUrl(String url) {
        this.URLBASE = url;
    }

    public void consultarOrden(int idOrder) {
        SerenityRest.
                given()
                .baseUri(URLBASE)
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .when()
                .log()
                .all()
                .get("/"+idOrder)

                .then()
                .log()
                .all();
    }

    public void validarRespuesta(int codigoRespuesta) {
        Assert.assertEquals(codigoRespuesta, lastResponse().getStatusCode());

    }

    public void validarIdOrden(int idOrder) {
        int idOrdenRespuesta = Integer.parseInt(lastResponse().body().path("id").toString());
        Assert.assertEquals(idOrder, idOrdenRespuesta);
    }

    public void validarPetId(int petId) {
        int idPetOrden = Integer.parseInt(lastResponse().body().path("petId").toString());
        Assert.assertEquals(petId, idPetOrden);
    }
}
