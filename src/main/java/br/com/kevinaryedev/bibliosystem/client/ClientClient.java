package br.com.kevinaryedev.bibliosystem.service;

import br.com.kevinaryedev.bibliosystem.data.changeless.ClientData;
import br.com.kevinaryedev.bibliosystem.spec.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ClientService {
    public static Response createClient(String json){
        return given()
                .log().all()
                .spec(RequestSpec.noAuth())
                .body(json)
            .when()
                .post(ClientData.SERVICE_CREATE)
            .then()
                .log().all()
                .extract().response()
        ;
    }
}
