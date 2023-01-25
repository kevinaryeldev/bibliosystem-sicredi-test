package br.com.kevinaryeldev.bibliosystem.contrato.book;

import br.com.kevinaryedev.bibliosystem.client.BookClient;
import br.com.kevinaryeldev.bibliosystem.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class BookListTest extends BaseTest {
    @Test
    @Tag("contrato")
    @Tag("livro")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Livro")
    @Story("Listar livros")
    @Description("Deve listar os livros da aplicação com sucesso")
    public void deveListarLivrosComSucesso() {
        Response response = BookClient.listBook(0,10);
        response.then().assertThat().body(matchesJsonSchema(new File("./src/jsonSchema/BookListSchema.json")));
    }

}
