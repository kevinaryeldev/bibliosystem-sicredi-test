package br.com.kevinaryeldev.bibliosystem.aceitacao.copy;

import br.com.kevinaryedev.bibliosystem.client.CopyClient;
import br.com.kevinaryedev.bibliosystem.data.factory.CopyCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.model.request.CopyCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.response.BookResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryedev.bibliosystem.utils.Utils;
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
public class CopyCreateTest  extends BaseTest {

    @BeforeAll
    public void setupBook() {
        this.book = preloadData.book();
    }
    CopyCreateRequestFactory copyCreateRequestFactory = CopyCreateRequestFactory.getInstance();
    PreloadData preloadData = PreloadData.getInstance();
    BookResponse book;

    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Criar exemplar")
    @Description("Deve criar um exemplar com sucesso")
    public void deveCriarUmExemplarComSucesso() {
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestValid(book.getId());
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Criar exemplar")
    @Description("Deve retornar erro ao criar um exemplar sem id do livro")
    public void deveRetornarErroAoCriarUmExemplarSemIdDoLivro() {
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestWithBookIdNull();
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Criar exemplar")
    @Description("Deve retornar erro ao criar um exemplar com id do livro inexistente")
    public void deveRetornarErroAoCriarUmExemplarComIdDoLivroInexistente() {
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestWithBookIdInvalid();
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Criar exemplar")
    @Description("Deve retornar erro ao criar um exemplar sem Edicao")
    public void deveRetornarErroAoCriarUmExemplarSemEdicao() {
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestWithEditionNull(book.getId());
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Criar exemplar")
    @Description("Deve retornar erro ao criar um exemplar sem edicao")
    public void deveRetornarErroAoCriarUmExemplarComEdicaoInvalida() {
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestWithEditionInvalid(book.getId());
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Criar exemplar")
    @Description("Deve retornar erro ao criar um exemplar sem Ano")
    public void deveRetornarErroAoCriarUmExemplarSemAno() {
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestWithYearNull(book.getId());
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Criar exemplar")
    @Description("Deve retornar erro ao criar um exemplar com Ano invalido")
    public void deveRetornarErroAoCriarUmExemplarComAnoInvalido() {
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestWithYearInvalid(book.getId());
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Criar exemplar")
    @Description("Deve retornar erro ao criar um exemplar sem codigo de patrimonio")
    public void deveRetornarErroAoCriarUmExemplarSemCodigoDePatrimonio() {
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestWithPropertyCodeNull(book.getId());
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
}
