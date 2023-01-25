package br.com.kevinaryedev.bibliosystem.data.request.client;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientEditRequest {
    private String name;
    private String email;
    private Character gender;
}