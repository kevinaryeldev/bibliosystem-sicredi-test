package br.com.kevinaryedev.bibliosystem.model.response;

import lombok.Getter;

@Getter
public class CopyWithDetailsResponse {
    private String year;
    private String property_code;
    private String edition;
    private Integer id_book;
    private Integer id;
    private String title;
    private String subtitle;
}
