package br.com.kevinaryedev.bibliosystem.model.response;

import lombok.Getter;

@Getter
public class BookResponse {
    private Integer id;
    private String title;
    private String subtitle;
    private String author;
    private String publisher;
    private String code;
    private String cdd;
}
