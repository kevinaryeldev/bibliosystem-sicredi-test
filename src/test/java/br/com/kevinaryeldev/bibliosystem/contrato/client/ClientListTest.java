package br.com.kevinaryeldev.bibliosystem.contrato.cliente;

import br.com.kevinaryedev.bibliosystem.client.ClientClient;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ClientListTest {
    @Test
    @Tag("contrato")
    @Tag("cliente")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Cliente")
    @Story("Listar clientes")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Deve listar os clientes da aplicação com sucesso")
    public void deveListarClientesComSucesso() {
        Response response = ClientClient.listClient(0,10);
        response.then().assertThat().body(matchesJsonSchema(new File("./src/jsonSchema/ClientListSchema.json")));
    }
}
