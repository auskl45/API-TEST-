package com.nttdata.glue;

import com.nttdata.step.TiendaMascota;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TiendaMascotaStepDefination {

    @Steps
    private TiendaMascota tienda;

    @Given("la url de la tienda es {string}")
    public void laUrlDeLaTiendaEs(String url) {
        tienda.setUrl(url);
    }

    @When("consulta de la mascota id {int}")
    public void consultaDeLaMascotaId(int idMascota) {
        tienda.consultaMascota(idMascota);
    }

    @Then("valido el codoigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int code) {
        tienda.validaRespuesta(code);
    }

    @And("valido el nombre de la mascota sea {string}")
    public void validoElNombreDeLaMascotaSea(String nombreMascota) {
        tienda.validarNombreMascota(nombreMascota);
    }

    @And("valido el parametro {string} tenga el contenido {string}")
    public void validoElParametroTengaElContenido(String parametro, String valor) {
        tienda.validoElParametroTengaElContenido(parametro,valor);
    }
}
