package br.com.kevinaryedev.bibliosystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookCreateRequest implements Cloneable {
    private String code;
    private String title;
    private String subtitle;
    private String publisher;
    private String author;
    private String cdd;

    public BookCreateRequest clone() {
        try {
            return (BookCreateRequest) super.clone();
        }  catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
