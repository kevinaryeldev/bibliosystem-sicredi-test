package br.com.kevinaryeldev.bibliosystem.aceitacao.loan;

import br.com.kevinaryedev.bibliosystem.client.LoanClient;
import br.com.kevinaryedev.bibliosystem.data.factory.LoanCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.model.request.LoanCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import br.com.kevinaryedev.bibliosystem.model.response.CopyResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryedev.bibliosystem.utils.Utils;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoanCreateTest extends BaseTest {

    LoanCreateRequestFactory loanCreateRequestFactory = LoanCreateRequestFactory.getInstance();

    PreloadData preloadData = PreloadData.getInstance();

    ClientResponse client;

    CopyResponse copy;

    @BeforeAll
    public void setupCopyAndClient() {
        this.client = preloadData.client();
        String idBook = preloadData.book().getId().toString();
        this.copy = preloadData.copy(idBook);
    }

    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Criar emprestimo")
    public void deveCriarEmprestimoComSucesso() {
        LoanCreateRequest loan = loanCreateRequestFactory.createLoanCreateRequestValid(client.getId(), copy.getId());
        String json = Utils.converterParaJson(loan);
        Response response = LoanClient.createLoan(json);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
    }

    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Criar emprestimo")
    public void naoDeveCriarEmprestimoComClienteInvalido() {
        LoanCreateRequest loan = loanCreateRequestFactory.createLoanCreateRequestWithIdClientInvalid(copy.getId_book());
        String json = Utils.converterParaJson(loan);
        Response response = LoanClient.createLoan(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Criar emprestimo")
    public void naoDeveCriarEmprestimoComExemplarInvalido() {
        LoanCreateRequest loan = loanCreateRequestFactory.createLoanCreateRequestWithIdCopyInvalid(client.getId());
        String json = Utils.converterParaJson(loan);
        Response response = LoanClient.createLoan(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Criar emprestimo")
    public void naoDeveCriarEmprestimoSemIdCliente() {
        LoanCreateRequest loan = loanCreateRequestFactory.createLoanCreateRequestWithIdClientNull(copy.getId_book());
        String json = Utils.converterParaJson(loan);
        Response response = LoanClient.createLoan(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("emprestimo")
    @Owner("Kevin Aryel")
    @Epic("Aceitacao")
    @Feature("Emprestimo")
    @Story("Criar emprestimo")
    public void naoDeveCriarEmprestimoSemIdExemplar() {
        LoanCreateRequest loan = loanCreateRequestFactory.createLoanCreateRequestWithIdCopyNull(client.getId());
        String json = Utils.converterParaJson(loan);
        Response response = LoanClient.createLoan(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }

}
