package br.com.kevinaryeldev.bibliosystem.aceitacao.client;

import br.com.kevinaryedev.bibliosystem.client.ClientClient;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClientDeleteTest extends BaseTest {
    PreloadData preloadData = PreloadData.getInstance();
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Deletar cliente")
    @Description("Deve deletar um cliente com sucesso")
    public void deveRetornarUmClienteComSucesso() {
        ClientResponse clientResponse = preloadData.client();
        String id = clientResponse.getId().toString();
        Response response = ClientClient.deleteClient(id);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Deletar cliente")
    @Description("Deve retornar erro ao tentar deletar um cliente com id inválido")
    public void deveRetornarErroAoTentarDeletarUmClienteComIdInvalido() {
        String id = "0";
        Response response = ClientClient.deleteClient(id);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
