package br.com.kevinaryedev.bibliosystem.client;

import br.com.kevinaryedev.bibliosystem.data.changeless.LoanData;
import br.com.kevinaryedev.bibliosystem.spec.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoanClient {
    public static Response createLoan(String json) {
        return given()
                .log().all()
                .spec(RequestSpec.noAuth())
                .body(json)
            .when()
                .post(LoanData.SERVICE_CREATE)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response listLoanByClientId(String id,Integer page,Integer size){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithQueryParamPaginationAndPathParamId(id,page,size))
            .when()
                .get(LoanData.SERVICE_FIND_BY_ID+"/{id}")
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response listLoanActive(Integer page,Integer size){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithQueryParamPagination(page,size))
            .when()
                .get(LoanData.SERVICE_FIND_ALL_ACTIVE)
            .then()
                .log().all()
                .extract().response()
        ;
    }
    public static Response updateLoan(String id){
        return given()
                .log().all()
                .spec(RequestSpec.noAuthWithPathParamId(id))
            .when()
                .patch(LoanData.SERVICE_UPDATE+"/{id}")
            .then()
                .log().all()
                .extract().response()
        ;
    }
}
