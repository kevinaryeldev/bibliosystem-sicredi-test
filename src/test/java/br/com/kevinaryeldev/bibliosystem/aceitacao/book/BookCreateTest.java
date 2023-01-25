package br.com.kevinaryeldev.bibliosystem.aceitacao.book;

import br.com.kevinaryedev.bibliosystem.client.BookClient;
import br.com.kevinaryedev.bibliosystem.data.factory.BookCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.model.request.BookCreateRequest;
import br.com.kevinaryedev.bibliosystem.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BookCreateTest {
    BookCreateRequestFactory bookCreateRequestFactory = BookCreateRequestFactory.getInstance();
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Deve criar um livro com sucesso")
    public void deveCriarUmLivroComSucesso() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestValid();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um livro sem titulo")
    public void deveRetornarErroAoCriarUmLivroSemTitulo() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithTitleNull();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um livro sem autor")
    public void deveRetornarErroAoCriarUmLivroSemAutor() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithAuthorNull();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao criar um livro sem isbn")
    public void deveRetornarErroAoCriarUmLivroSemIsbn() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithCodeNull();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve criar um livro sem subtitulo com sucesso")
    public void deveCriarUmLivroSemSubtituloComSucesso() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithSubtitleNull();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao tentar criar um livro sem editora")
    public void deveRetornarErroAoTentarCriarUmLivroSemEditora() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithPublisherNull();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao tentar criar um livro sem cdd")
    public void deveRetornarErroAoTentarCriarUmLivroSemCdd() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithCddNull();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao tentar criar um livro com isbn invalido")
    public void deveRetornarErroAoTentarCriarUmLivroComIsbnInvalido() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithCodeInvalid();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao tentar criar um livro com editora invalida")
    public void deveRetornarErroAoTentarCriarUmLivroComEditoraInvalida() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithPublisherInvalid();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao tentar criar um livro com cdd invalido")
    public void deveRetornarErroAoTentarCriarUmLivroComCddInvalido() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithCddInvalid();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Criar livro")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve retornar erro ao tentar criar um livro com autor invalido")
    public void deveRetornarErroAoTentarCriarUmLivroComAutorInvalido() {
        BookCreateRequest bookCreateRequest = bookCreateRequestFactory.createBookCreateRequestWithAuthorInvalid();
        String json = Utils.converterParaJson(bookCreateRequest);
        Response response = BookClient.createBook(json);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }

}
