package br.com.kevinaryedev.bibliosystem.client;

import br.com.kevinaryedev.bibliosystem.data.changeless.ClientData;
import br.com.kevinaryedev.bibliosystem.spec.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ClientClient {
    public static Response createClient(String json){
        return given()
                .log().all()
                .spec(RequestSpec.noAuth())
                .body(json)
            .when()
                .post(ClientData.SERVICE_CREATE);
    }
    public static Response listClient(Integer page, Integer size){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithQueryParamPagination(page,size))
            .when()
                .get(ClientData.SERVICE_FIND_ALL)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response editClient(String id, String json){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithPathParamId(id))
                .body(json)
            .when()
                .put(ClientData.SERVICE_UPDATE)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response deleteClient(String id){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithPathParamId(id))
            .when()
                .delete(ClientData.SERVICE_DELETE)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response findClientById(String id){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithPathParamId(id))
            .when()
                .get(ClientData.SERVICE_FIND_BY_ID)
            .then()
                .log().all()
                .extract().response()
        ;
    }
}
