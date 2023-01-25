package br.com.kevinaryedev.bibliosystem.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClientResponse {
    private Integer id;
    private String name;
    private String document;
    private String email;
    private Character gender;
    private String birth_date;
}
