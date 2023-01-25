package br.com.kevinaryedev.bibliosystem.model.request;

import java.time.LocalDate;

public class ClientCreateRequestBuilder {
    private String name;
    private String document;
    private String email;
    private Character gender;
    private LocalDate birth_date;

    public ClientCreateRequestBuilder name(String name) {
        this.name = name;
        return this;
    }
    public ClientCreateRequestBuilder document(String document) {
        this.document = document;
        return this;
    }
    public ClientCreateRequestBuilder email(String email) {
        this.email = email;
        return this;
    }
    public ClientCreateRequestBuilder gender(Character gender) {
        this.gender = gender;
        return this;
    }
    public ClientCreateRequestBuilder birth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
        return this;
    }
    public ClientCreateRequest build() {
        return new ClientCreateRequest(name, document, email, gender, birth_date);
    }
}
