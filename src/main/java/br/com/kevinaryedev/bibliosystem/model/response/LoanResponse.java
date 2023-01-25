package br.com.kevinaryedev.bibliosystem.model.response;

import lombok.Getter;

@Getter
public class LoanResponse {
    private Integer id;
    private Character status;
    private String loan_date;
    private String return_date;
    private CopyResponse copy;
    private ClientResponse client;

}
