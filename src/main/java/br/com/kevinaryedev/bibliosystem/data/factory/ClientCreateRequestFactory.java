package br.com.kevinaryedev.bibliosystem.data.factory;

import br.com.kevinaryedev.bibliosystem.data.config.ClientDataConfig;
import br.com.kevinaryedev.bibliosystem.model.request.ClientCreateRequest;

public class ClientCreateRequestFactory {
        private ClientCreateRequest validClientCreateRequest;

        public ClientCreateRequestFactory(ClientCreateRequest validClientCreateRequest) {
            this.validClientCreateRequest = validClientCreateRequest;
        }

        public ClientCreateRequest createClientCreateRequestValid(){
            return validClientCreateRequest.clone();
        }

        public ClientCreateRequest createClientCreateRequestWithNameNull(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setName(null);
            return client;
        }

        public ClientCreateRequest createClientCreateRequestWithEmailNull(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setEmail(null);
            return client;
        }

        public ClientCreateRequest createClientCreateRequestWithDocumentNull(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setDocument(null);
            return client;
        }
        public ClientCreateRequest createClientCreateRequestWithBirthDateNull(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setBirth_date(null);
            return client;
        }
        public ClientCreateRequest createClientCreateRequestWithGenderNull(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setGender(null);
            return client;
        }

        public ClientCreateRequest createClientCreateRequestWithNameInvalid(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setName(ClientDataConfig.invalidName());
            return client;
        }
        public ClientCreateRequest createClientCreateRequestWithEmailInvalid(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setEmail(ClientDataConfig.invalidEmail());
            return client;
        }
        public ClientCreateRequest createClientCreateRequestWithDocumentInvalid(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setDocument(ClientDataConfig.invalidDocument());
            return client;
        }
        public ClientCreateRequest createClientCreateRequestWithGenderInvalid(){
            ClientCreateRequest client = validClientCreateRequest.clone();
            client.setGender(ClientDataConfig.invalidGender());
            return client;
        }
}
