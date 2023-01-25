package br.com.kevinaryeldev.bibliosystem.aceitacao.client;

import br.com.kevinaryedev.bibliosystem.data.factory.ClientCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.data.provider.DataProvider;
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

    ClientCreateRequestFactory clientCreateRequestFactory = new ClientCreateRequestFactory(DataProvider.getValidClientCreateRequest());

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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestValid();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithNameNull();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithDocumentNull();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithEmailNull();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithGenderNull();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithBirthDateNull();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithNameInvalid();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithDocumentInvalid();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithEmailInvalid();
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
        ClientCreateRequest clientCreateRequest = clientCreateRequestFactory.createClientCreateRequestWithGenderInvalid();
        Response response = ClientClient.createClient(Utils.converterParaJson(clientCreateRequest));
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
}
