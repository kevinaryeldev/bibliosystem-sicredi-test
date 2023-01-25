package br.com.kevinaryedev.bibliosystem.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public static RequestSpecification noAuth() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
    public static RequestSpecification noAuthWithPathParamId(String id){
        return new RequestSpecBuilder()
                .addPathParam("id",id)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static RequestSpecification noAuthWithQueryParamPagination(Integer page,Integer size){
        return new RequestSpecBuilder()
                .addQueryParam("page",page)
                .addQueryParam("size",size)
                .setContentType(ContentType.JSON)
                .build();
    }
}

