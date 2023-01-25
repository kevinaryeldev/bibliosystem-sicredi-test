package br.com.kevinaryedev.bibliosystem.model.request;

public class CopyCreateRequestBuilder {
    private String year;
    private String property_code;
    private String edition;
    private Integer id_book;

    public CopyCreateRequestBuilder year(String year) {
        this.year = year;
        return this;
    }

    public CopyCreateRequestBuilder property_code(String property_code) {
        this.property_code = property_code;
        return this;
    }

    public CopyCreateRequestBuilder edition(String edition) {
        this.edition = edition;
        return this;
    }

    public CopyCreateRequestBuilder id_book(Integer id_book) {
        this.id_book = id_book;
        return this;
    }

    public CopyCreateRequest build() {
        return new CopyCreateRequest(year, property_code, edition, id_book);
    }
}
