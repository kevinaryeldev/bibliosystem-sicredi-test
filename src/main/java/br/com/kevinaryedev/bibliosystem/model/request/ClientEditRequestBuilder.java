package br.com.kevinaryedev.bibliosystem.model.request;

public class ClientEditRequestBuilder {
    private String name;
    private String email;
    private Character gender;

    public ClientEditRequestBuilder name(String name) {
        this.name = name;
        return this;
    }
    public ClientEditRequestBuilder email(String email) {
        this.email = email;
        return this;
    }
    public ClientEditRequestBuilder gender(Character gender){
        this.gender = gender;
        return this;
    }

    public ClientEditRequest build(){
        return new ClientEditRequest(name,email,gender);
    }

}
