package br.com.kevinaryedev.bibliosystem.model.request;

public class BookCreateRequestBuilder {
    private String code;
    private String title;
    private String subtitle;
    private String publisher;
    private String author;
    private String cdd;

    public BookCreateRequestBuilder code(String code) {
        this.code = code;
        return this;
    }
    public BookCreateRequestBuilder title(String title) {
        this.title = title;
        return this;
    }
    public BookCreateRequestBuilder subtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }
    public BookCreateRequestBuilder publisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
    public BookCreateRequestBuilder author(String author) {
        this.author = author;
        return this;
    }
    public BookCreateRequestBuilder cdd(String cdd) {
        this.cdd = cdd;
        return this;
    }
    public BookCreateRequest build() {
        return new BookCreateRequest(code, title, subtitle, publisher, author, cdd);
    }

}
