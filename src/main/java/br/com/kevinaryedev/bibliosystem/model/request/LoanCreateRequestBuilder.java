package br.com.kevinaryedev.bibliosystem.model.request;

public class LoanCreateRequestBuilder {
    private Integer id_copy;
    private Integer id_client;

    public LoanCreateRequestBuilder idCopy(Integer id_copy) {
        this.id_copy = id_copy;
        return this;
    }
    public LoanCreateRequestBuilder idClient(Integer id_client) {
        this.id_client = id_client;
        return this;
    }
    public LoanCreateRequest build() {
        return new LoanCreateRequest(id_copy, id_client);
    }
}
