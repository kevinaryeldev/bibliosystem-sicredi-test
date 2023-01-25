package br.com.kevinaryeldev.bibliosystem.aceitacao.loan;

import br.com.kevinaryedev.bibliosystem.client.LoanClient;
import br.com.kevinaryedev.bibliosystem.model.response.LoanResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoanEditTest extends BaseTest {

    PreloadData preloadData = PreloadData.getInstance();

    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Devolver emprestimo")
    @Description("Deve devolver um emprestimo com sucesso")
    public void deveDevolverEmprestimoComSucesso() {
        LoanResponse loanResponse = preloadData.loan();
        String id = loanResponse.getId().toString();
        Response response = LoanClient.updateLoan(id);
        Assert.assertEquals(HttpStatus.SC_ACCEPTED, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Devolver emprestimo")
    @Description("Deve retornar erro ao tentar devolver um emprestimo com id inválido")
    public void deveRetornarErroAoTentarDevolverEmprestimoComIdInvalido() {
        String id = "0";
        Response response = LoanClient.updateLoan(id);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
