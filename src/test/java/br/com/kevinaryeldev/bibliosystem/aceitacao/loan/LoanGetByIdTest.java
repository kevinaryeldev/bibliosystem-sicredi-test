package br.com.kevinaryeldev.bibliosystem.aceitacao.loan;

import br.com.kevinaryedev.bibliosystem.client.LoanClient;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoanGetByIdTest extends BaseTest {
    PreloadData preloadData = PreloadData.getInstance();
    ClientResponse client;
    @BeforeAll
    public void setupClient() {
        this.client = preloadData.client();
    }

    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Buscar emprestimos por id do cliente")
    @Description("Deve retornar uma lista de emprestimos vazia com sucesso")
    public void deveRetornarUmaListaDeEmprestimoVaziaComSucesso() {
        String id = client.getId().toString();
        Response response = LoanClient.listLoanByClientId(id,null,null);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Buscar emprestimo por id do cliente")
    @Description("Deve retornar uma lista de emprestimos com sucesso")
    public void deveRetornarUmaListaDeEmprestimoComSucesso() {
        String id = client.getId().toString();
        preloadData.loanForClient(client.getId());
        Response response = LoanClient.listLoanByClientId(id,null,null);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Buscar emprestimo por id do cliente")
    @Description("Deve retornar erro ao tentar buscar emprestimo com id do cliente inválido")
    public void deveRetornarErroAoTentarBuscarEmprestimoComIdDoClienteInvalido() {
        String id = "0";
        Response response = LoanClient.listLoanByClientId(id,null,null);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
