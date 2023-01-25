package br.com.kevinaryeldev.bibliosystem.contrato.loan;

import br.com.kevinaryedev.bibliosystem.client.LoanClient;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class LoanListTest extends BaseTest {
    @Test
    @Tag("contrato")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Emprestimo")
    @Story("Listar emprestimos ativos")
    @Description("Deve listar os emprestimos ativos da aplicação com sucesso")
    public void deveListarEmprestimosAtivosComSucesso() {
        Response response = LoanClient.listLoanActive(0,10);
        response.then().assertThat().body(matchesJsonSchema(new File("./src/jsonSchema/LoanListSchema.json")));
    }
}
