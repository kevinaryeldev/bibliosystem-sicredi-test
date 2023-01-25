package br.com.kevinaryeldev.bibliosystem.aceitacao.client;

import br.com.kevinaryedev.bibliosystem.client.ClientClient;
import br.com.kevinaryedev.bibliosystem.data.factory.ClientEditRequestFactory;
import br.com.kevinaryedev.bibliosystem.model.request.ClientEditRequest;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryedev.bibliosystem.utils.Utils;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientEditTest  extends BaseTest {
    PreloadData preloadData = PreloadData.getInstance();
    ClientEditRequestFactory clientEditRequestFactory = ClientEditRequestFactory.getInstance();
    ClientResponse clientResponse;

    @BeforeAll
    public void setupClient() {
        clientResponse = preloadData.client();
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Editar cliente")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve editar um cliente com sucesso")
    public void deveEditarUmClienteComSucesso() {
        String id = clientResponse.getId().toString();
        ClientEditRequest request = clientEditRequestFactory.createClientEditRequestValid();
        String json = Utils.converterParaJson(request);
        Response response = ClientClient.editClient(id, json);
        Assert.assertEquals(200, response.getStatusCode());
        ClientResponse result = response.as(ClientResponse.class);
        Assert.assertEquals(request.getName(), result.getName());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Editar cliente")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um cliente sem nome")
    public void deveRetornarErroAoTentarEditarUmClienteSemNome() {
        String id = clientResponse.getId().toString();
        ClientEditRequest request = clientEditRequestFactory.createClientEditRequestWithNameNull();
        String json = Utils.converterParaJson(request);
        Response response = ClientClient.editClient(id, json);
        Assert.assertEquals(400, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Editar cliente")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um cliente com nome inválido")
    public void deveRetornarErroAoTentarEditarUmClienteComNomeInvalido() {
        String id = clientResponse.getId().toString();
        ClientEditRequest request = clientEditRequestFactory.createClientEditRequestWithNameInvalid();
        String json = Utils.converterParaJson(request);
        Response response = ClientClient.editClient(id, json);
        Assert.assertEquals(400, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Editar cliente")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um cliente sem email")
    public void deveRetornarErroAoTentarEditarUmClienteSemEmail() {
        String id = clientResponse.getId().toString();
        ClientEditRequest request = clientEditRequestFactory.createClientEditRequestWithEmailNull();
        String json = Utils.converterParaJson(request);
        Response response = ClientClient.editClient(id, json);
        Assert.assertEquals(400, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Editar cliente")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um cliente com email inválido")
    public void deveRetornarErroAoTentarEditarUmClienteComEmailInvalido() {
        String id = clientResponse.getId().toString();
        ClientEditRequest request = clientEditRequestFactory.createClientEditRequestWithEmailInvalid();
        String json = Utils.converterParaJson(request);
        Response response = ClientClient.editClient(id, json);
        Assert.assertEquals(400, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Editar cliente")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um cliente sem genero")
    public void deveRetornarErroAoTentarEditarUmClienteSemGenero() {
        String id = clientResponse.getId().toString();
        ClientEditRequest request = clientEditRequestFactory.createClientEditRequestWithGenderNull();
        String json = Utils.converterParaJson(request);
        Response response = ClientClient.editClient(id, json);
        Assert.assertEquals(400, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Cliente")
    @Story("Editar cliente")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um cliente com genero inválido")
    public void deveRetornarErroAoTentarEditarUmClienteComGeneroInvalido() {
        String id = clientResponse.getId().toString();
        ClientEditRequest request = clientEditRequestFactory.createClientEditRequestWithGenderInvalid();
        String json = Utils.converterParaJson(request);
        Response response = ClientClient.editClient(id, json);
        Assert.assertEquals(400, response.getStatusCode());
    }

}
