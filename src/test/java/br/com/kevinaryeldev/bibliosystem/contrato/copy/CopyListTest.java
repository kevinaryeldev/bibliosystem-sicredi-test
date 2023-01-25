package br.com.kevinaryeldev.bibliosystem.contrato.copy;

import br.com.kevinaryedev.bibliosystem.client.CopyClient;
import br.com.kevinaryedev.bibliosystem.model.response.BookResponse;
import br.com.kevinaryedev.bibliosystem.model.response.CopyResponse;
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

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CopyListTest extends BaseTest {
    PreloadData preloadData = PreloadData.getInstance();

    BookResponse bookResponse;
    @BeforeAll
    public void setupBook() {
        this.bookResponse = preloadData.book();
    }

    @Test
    @Tag("contrato")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Exemplar")
    @Story("Listar exemplares por livro")
    @Description("Deve listar os exemplares por livro da aplicação vazio com sucesso")
    public void deveListarExemplarVazioComSucesso() {
        String idBook = bookResponse.getId().toString();
        Response response = CopyClient.listCopy(idBook,0,10);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        response.then().assertThat().body(matchesJsonSchema(new File("./src/jsonSchema/CopyListSchema.json")));
    }
    @Test
    @Tag("contrato")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Exemplar")
    @Story("Listar exemplares por livro")
    @Description("Deve listar os exemplares por livro da aplicação com sucesso")
    public void deveListarExemplarComSucesso() {
        String idBook = bookResponse.getId().toString();
        CopyResponse copyResponse = preloadData.copy(idBook);
        Response response = CopyClient.listCopy(idBook,0,10);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        response.then().assertThat().body(matchesJsonSchema(new File("./src/jsonSchema/CopyListSchema.json")));
    }
    @Test
    @Tag("contrato")
    @Tag("exemplar")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Exemplar")
    @Story("Listar exemplares por livro")
    @Description("Deve listar os exemplares por livro da aplicação com sucesso")
    public void deveListarExemplaresComSucesso3() {
        String idBook = bookResponse.getId().toString();
        CopyResponse copyResponse = preloadData.copy(idBook);
        Response response = CopyClient.listCopy(idBook,0,10);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

}

