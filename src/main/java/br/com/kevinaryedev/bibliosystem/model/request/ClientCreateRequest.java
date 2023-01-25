package br.com.kevinaryedev.bibliosystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class ClientCreateRequest implements Cloneable{
    private String name;
    private String document;
    private String email;
    private Character gender;
    private LocalDate birth_date;

    public ClientCreateRequest clone() {
        try {
            return (ClientCreateRequest) super.clone();
        }  catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
