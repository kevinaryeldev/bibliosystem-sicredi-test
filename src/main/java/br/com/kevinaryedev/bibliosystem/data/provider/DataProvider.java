package br.com.kevinaryedev.bibliosystem.data.provider;

import br.com.kevinaryedev.bibliosystem.data.config.BookDataConfig;
import br.com.kevinaryedev.bibliosystem.data.config.ClientDataConfig;
import br.com.kevinaryedev.bibliosystem.data.config.CopyDataConfig;
import br.com.kevinaryedev.bibliosystem.model.request.*;

public class DataProvider {
    public static ClientCreateRequest getValidClientCreateRequest(){
        return new ClientCreateRequestBuilder()
                .name(ClientDataConfig.validName())
                .document(ClientDataConfig.validDocument())
                .email(ClientDataConfig.validEmail())
                .gender(ClientDataConfig.validGender())
                .birth_date(ClientDataConfig.validBirthDate())
                .build();
    }
    public static ClientEditRequest getValidClientEditRequest(){
        return new ClientEditRequestBuilder()
                .name(ClientDataConfig.validName())
                .gender(ClientDataConfig.validGender())
                .email(ClientDataConfig.validEmail())
                .build();
    }
    public static BookCreateRequest getValidBookCreateRequest(){
        return new BookCreateRequestBuilder()
                .title(BookDataConfig.validTitle())
                .code(BookDataConfig.validCode())
                .subtitle(BookDataConfig.validSubtitle())
                .publisher(BookDataConfig.validPublisher())
                .author(BookDataConfig.validAuthor())
                .cdd(BookDataConfig.validCdd())
                .build();
    }
    public static CopyCreateRequest getValidCopyCreateRequest(){
        return new CopyCreateRequestBuilder()
                .year(CopyDataConfig.validYear())
                .property_code(CopyDataConfig.validPropertyCode())
                .edition(CopyDataConfig.validEdition())
                .id_book(0)
                .build();
    }
}
