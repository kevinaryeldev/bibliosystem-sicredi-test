package br.com.kevinaryeldev.bibliosystem.aceitacao.copy;

import br.com.kevinaryedev.bibliosystem.client.CopyClient;
import br.com.kevinaryedev.bibliosystem.utils.PreloadData;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CopyGetByIdTest extends BaseTest {
    PreloadData preloadData = PreloadData.getInstance();
    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Buscar exemplar por id")
    @Description("Deve retornar um exemplar com sucesso")
    public void deveRetornarUmExemplarComSucesso() {
        String idBook = preloadData.book().getId().toString();
        String idCopy = preloadData.copy(idBook).getId().toString();
        Response response = CopyClient.findCopyById(idCopy);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
    @Test
    @Tag("aceitacao")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Exemplar")
    @Story("Buscar exemplar por id")
    @Description("Deve retornar erro ao buscar um exemplar inexistente")
    public void deveRetornarErroAoBuscarUmExemplarInexistente() {
        Response response = CopyClient.findCopyById("0");
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }

}
