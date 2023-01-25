package br.com.kevinaryeldev.bibliosystem.aceitacao.book;

import br.com.kevinaryedev.bibliosystem.client.BookClient;
import br.com.kevinaryedev.bibliosystem.model.response.BookResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BookGetByIdTest  extends BaseTest {
    PreloadData preloadData = new PreloadData();

    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Buscar livro por id")
    public void deveRetornarUmLivroComSucesso() {
        BookResponse bookResponse = preloadData.book();
        String id = bookResponse.getId().toString();
        Response response = BookClient.findBookById(id);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Buscar livro por id")
    public void deveRetornarErroAoTentarBuscarUmLivroComIdInvalido() {
        String id = "0";
        Response response = BookClient.findBookById(id);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
