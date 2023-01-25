package br.com.kevinaryeldev.bibliosystem.aceitacao.client;

import br.com.kevinaryedev.bibliosystem.client.ClientClient;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
public class ClientGetByIdTest  extends BaseTest {

    PreloadData preloadData = PreloadData.getInstance();

    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Buscar cliente por id")
    @Severity(SeverityLevel.NORMAL)
    @Description("Deve retornar um cliente com sucesso")
    public void deveRetornarUmClienteComSucesso() {
        ClientResponse clientResponse = preloadData.client();
        String id = clientResponse.getId().toString();
        Response response = ClientClient.findClientById(id);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Buscar cliente por id")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar buscar um cliente com id inválido")
    public void deveRetornarErroAoTentarBuscarUmClienteComIdInvalido() {
        String id = "0";
        Response response = ClientClient.findClientById(id);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
