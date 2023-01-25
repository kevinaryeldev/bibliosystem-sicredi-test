package br.com.kevinaryedev.bibliosystem.data.provider;

import br.com.kevinaryedev.bibliosystem.data.config.ClientDataConfig;
import br.com.kevinaryedev.bibliosystem.model.request.ClientCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.request.ClientCreateRequestBuilder;
import br.com.kevinaryedev.bibliosystem.model.request.ClientEditRequest;
import br.com.kevinaryedev.bibliosystem.model.request.ClientEditRequestBuilder;

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
}
