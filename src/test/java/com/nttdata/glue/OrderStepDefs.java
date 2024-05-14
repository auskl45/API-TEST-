package com.nttdata.glue;

import com.nttdata.step.ArticuloStep;
import com.nttdata.step.OrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class OrderStepDefs {
    @Steps
    OrderStep orderStep;

    @When("creo la orden con id {int}, petId {int} y cantidad {int}")
    public void creoLaOrdenConIdIdOrderPetIdPetIdCantidadQuantity(int idOrder, int petId, int cantidad) {
        orderStep.crearOrden(idOrder,petId,cantidad);

    }
    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
    @And("valido el id de la mascota sea {int}")
    public void validoElIdDeLaMascotaSeaPetId(int petId) {
        orderStep.validarPetId(petId);
    }

    @Given("la url de las ordenes de la tienda es {string}")
    public void laUrlDeLasOrdenesDeLaTiendaEs(String url) {
        orderStep.setUrl(url);
    }

    @When("consulta de la orden id {int}")
    public void consultaDeLaOrdenIdIdOrder(int idOrder) {
        orderStep.consultarOrden(idOrder);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSeaCodigoRespuesta(int codigoRespuesta) {
        orderStep.validarRespuesta(codigoRespuesta);
    }

    @And("valido el id de la orden sea {int}")
    public void validoElIdDeLaOrdenSeaIdOrder(int idOrder) {
        orderStep.validarIdOrden(idOrder);
    }


}
