package br.com.kevinaryedev.bibliosystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoanCreateRequest implements Cloneable{
    private Integer id_copy;
    private Integer id_client;

    public LoanCreateRequest clone() {
        try {
            return (LoanCreateRequest) super.clone();
        }  catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
