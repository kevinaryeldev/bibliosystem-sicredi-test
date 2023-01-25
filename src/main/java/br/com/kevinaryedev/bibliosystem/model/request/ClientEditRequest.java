package br.com.kevinaryedev.bibliosystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientEditRequest implements Cloneable{
    private String name;
    private String email;
    private Character gender;

    public ClientEditRequest clone() {
        try {
            return (ClientEditRequest) super.clone();
        }  catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}