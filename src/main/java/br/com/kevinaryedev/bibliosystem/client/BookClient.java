package br.com.kevinaryedev.bibliosystem.client;

import br.com.kevinaryedev.bibliosystem.data.changeless.BookData;
import br.com.kevinaryedev.bibliosystem.spec.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookClient {

    public static Response createBook(String json){
        return given()
                .log().all()
                .spec(RequestSpec.noAuth())
                .body(json)
            .when()
                .post(BookData.SERVICE_CREATE)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response listBook(Integer page, Integer size){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithQueryParamPagination(page,size))
            .when()
                .get(BookData.SERVICE_FIND_ALL)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response deleteBook(String id){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithPathParamId(id))
            .when()
                .delete(BookData.SERVICE_DELETE)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response findBookById(String id){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithPathParamId(id))
            .when()
                .get(BookData.SERVICE_FIND_BY_ID)
            .then()
                .log().all()
                .extract().response()
        ;
    }

}
