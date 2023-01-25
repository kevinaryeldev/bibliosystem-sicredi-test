package br.com.kevinaryeldev.bibliosystem.aceitacao.cliente;

import br.com.kevinaryedev.bibliosystem.data.factory.ClientCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.model.request.ClientCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import br.com.kevinaryedev.bibliosystem.client.ClientClient;
import br.com.kevinaryedev.bibliosystem.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClientCreateTest {
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Deve criar um cliente com sucesso")
    public void deveCriarUmClienteComSucesso() {
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestValid();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
        ClientResponse responseExtracted =  response.as(ClientResponse.class);
        Assert.assertEquals(clientCreateRequest.getName(), responseExtracted.getName());
    }

    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente sem nome")
    public void deveRetornarErroAoCriarUmClienteSemNome() {
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestNullName();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente sem documento")
    public void deveRetornarErroAoCriarUmClienteSemDocumento() {
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestNullDocument();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente sem email")
    public void deveRetornarErroAoCriarUmClienteSemEmail() {
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestNullEmail();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente sem genero")
    public void deveRetornarErroAoCriarUmClienteSemGenero(){
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestNullGender();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente sem data de nascimento")
    public void deveRetornarErroAoCriarUmClienteSemDataDeNascimento(){
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestNullBirthDate();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente com nome inválido")
    public void deveRetornarErroAoCriarUmClienteComNomeInvalido(){
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestInvalidName();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente com documento inválido")
    public void deveRetornarErroAoCriarUmClienteComDocumentoInvalido(){
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestInvalidDocument();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente com email inválido")
    public void deveRetornarErroAoCriarUmClienteComEmailInvalido(){
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestInvalidEmail();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Criar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um cliente com genero inválido")
    public void deveRetornarErroAoCriarUmClienteComGeneroInvalido(){
        ClientCreateRequest clientCreateRequest = ClientCreateRequestFactory.clientCreateRequestInvalidGender();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
}
