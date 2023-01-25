package br.com.kevinaryedev.bibliosystem.client;

import br.com.kevinaryedev.bibliosystem.data.changeless.CopyData;
import br.com.kevinaryedev.bibliosystem.spec.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CopyClient {
    public static Response createCopy(String json) {
        return given()
                .log().all()
                .spec(RequestSpec.noAuth())
                .body(json)
            .when()
                .post(CopyData.SERVICE_CREATE)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response listCopy(String id,Integer page,Integer size){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithQueryParamPaginationAndPathParamId(id,page,size))
            .when()
                .get(CopyData.SERVICE_FIND_BY_BOOK_ID+"/{id}")
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response deleteCopy(String id){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithPathParamId(id))
            .when()
                .delete(CopyData.SERVICE_DELETE+"/{id}")
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response findCopyById(String id){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithPathParamId(id))
            .when()
                .get(CopyData.SERVICE_FIND_BY_ID+"/{id}")
            .then()
                .log().all()
                .extract().response()
        ;
    }

}
