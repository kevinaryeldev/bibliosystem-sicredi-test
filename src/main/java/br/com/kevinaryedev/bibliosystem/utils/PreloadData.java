package br.com.kevinaryedev.bibliosystem.utils;

import br.com.kevinaryedev.bibliosystem.client.ClientClient;
import br.com.kevinaryedev.bibliosystem.data.factory.ClientCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.data.provider.DataProvider;
import br.com.kevinaryedev.bibliosystem.model.request.ClientCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import io.restassured.response.Response;

public class PreloadData {
    ClientCreateRequestFactory clientCreateRequestFactory = new ClientCreateRequestFactory(DataProvider.getValidClientCreateRequest());

    public ClientResponse client() {
        ClientCreateRequest client = clientCreateRequestFactory.createClientCreateRequestValid();
        String json = Utils.converterParaJson(client);
        Response response = ClientClient.createClient(json);
        return response.as(ClientResponse.class);
    }
}
