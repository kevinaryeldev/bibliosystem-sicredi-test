package br.com.kevinaryedev.bibliosystem.data.factory;

import br.com.kevinaryedev.bibliosystem.data.config.ClientDataConfig;
import br.com.kevinaryedev.bibliosystem.model.request.ClientEditRequest;

public class ClientEditRequestFactory {

    private ClientEditRequest validClientEditRequest;

    public ClientEditRequestFactory(ClientEditRequest validClientEditRequest) {
        this.validClientEditRequest = validClientEditRequest;
    }
    public ClientEditRequest createClientEditRequestValid(){
        return validClientEditRequest.clone();
    }
    public ClientEditRequest createClientEditRequestWithNameNull(){
        ClientEditRequest client = validClientEditRequest.clone();
        client.setName(null);
        return client;
    }
    public ClientEditRequest createClientEditRequestWithEmailNull(){
        ClientEditRequest client = validClientEditRequest.clone();
        client.setEmail(null);
        return client;
    }
    public ClientEditRequest createClientEditRequestWithGenderNull(){
        ClientEditRequest client = validClientEditRequest.clone();
        client.setGender(null);
        return client;
    }
    public ClientEditRequest createClientEditRequestWithNameInvalid(){
        ClientEditRequest client = validClientEditRequest.clone();
        client.setName(ClientDataConfig.invalidName());
        return client;
    }
    public ClientEditRequest createClientEditRequestWithEmailInvalid(){
        ClientEditRequest client = validClientEditRequest.clone();
        client.setEmail(ClientDataConfig.invalidEmail());
        return client;
    }
    public ClientEditRequest createClientEditRequestWithGenderInvalid(){
        ClientEditRequest client = validClientEditRequest.clone();
        client.setGender(ClientDataConfig.invalidGender());
        return client;
    }
}
