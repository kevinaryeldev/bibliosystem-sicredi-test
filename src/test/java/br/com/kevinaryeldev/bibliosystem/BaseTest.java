package br.com.kevinaryeldev.bibliosystem;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setup(){
        System.out.println("Iniciando os testes");
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = "http://localhost:8080/bibliosystem/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
