package br.com.kevinaryeldev.bibliosystem.aceitacao.copy;

import br.com.kevinaryedev.bibliosystem.client.CopyClient;
import br.com.kevinaryedev.bibliosystem.model.response.BookResponse;
import br.com.kevinaryedev.bibliosystem.model.response.CopyResponse;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CopyDeleteTest extends BaseTest {
    PreloadData preloadData = new PreloadData();

    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Deletar exemplar")
    @Description("Deve deletar um exemplar com sucesso")
    public void deveDeletarUmExemplarComSucesso() {
        BookResponse book = preloadData.book();
        String idBook = book.getId().toString();
        CopyResponse copy = preloadData.copy(idBook);
        String idCopy = copy.getId().toString();
        Response response = CopyClient.deleteCopy(idCopy);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Deletar exemplar")
    @Description("Deve retornar erro ao deletar um exemplar inexistente")
    public void deveRetornarErroAoDeletarUmExemplarInexistente() {
        Response response = CopyClient.deleteCopy("0");
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
