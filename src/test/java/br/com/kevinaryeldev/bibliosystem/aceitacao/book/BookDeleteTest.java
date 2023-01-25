package br.com.kevinaryeldev.bibliosystem.aceitacao.book;

import br.com.kevinaryedev.bibliosystem.client.BookClient;
import br.com.kevinaryedev.bibliosystem.model.response.BookResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BookDeleteTest  extends BaseTest {
    PreloadData preloadData = new PreloadData();

    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Deletar livro")
    @Description("Deve deletar um livro com sucesso")
    public void deveDeletarUmLivroComSucesso() {
        BookResponse bookResponse = preloadData.book();
        String id = bookResponse.getId().toString();
        Response response = BookClient.deleteBook(id);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Livro")
    @Story("Deletar livro")
    @Description("Deve retornar erro ao tentar deletar um livro com id inválido")
    public void deveRetornarErroAoTentarDeletarUmLivroComIdInvalido() {
        String id = "0";
        Response response = BookClient.deleteBook(id);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }

}
