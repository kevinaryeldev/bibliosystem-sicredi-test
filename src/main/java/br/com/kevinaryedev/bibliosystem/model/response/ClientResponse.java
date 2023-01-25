package br.com.kevinaryedev.bibliosystem.model.response;

import lombok.Getter;

@Getter
public class ClientResponse {
    private Integer id;
    private String name;
    private String document;
    private String email;
    private Character gender;
    private String birth_date;
}
