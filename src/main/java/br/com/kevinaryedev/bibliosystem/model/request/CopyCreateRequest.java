package br.com.kevinaryedev.bibliosystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CopyCreateRequest implements Cloneable{
    private String year;
    private String property_code;
    private String edition;
    private Integer id_book;

    public CopyCreateRequest clone() {
        try {
            return (CopyCreateRequest) super.clone();
        }  catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
