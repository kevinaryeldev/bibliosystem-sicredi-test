package br.com.kevinaryedev.bibliosystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class ClientCreateModelRequest {
    private String name;
    private String document;
    private String email;
    private Character gender;
    private LocalDate birth_date;
}
