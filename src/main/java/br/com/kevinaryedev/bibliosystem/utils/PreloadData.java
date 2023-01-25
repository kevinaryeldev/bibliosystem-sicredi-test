package br.com.kevinaryedev.bibliosystem.utils;

import br.com.kevinaryedev.bibliosystem.client.BookClient;
import br.com.kevinaryedev.bibliosystem.client.ClientClient;
import br.com.kevinaryedev.bibliosystem.data.factory.BookCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.data.factory.ClientCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.data.provider.DataProvider;
import br.com.kevinaryedev.bibliosystem.model.request.BookCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.request.ClientCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.response.BookResponse;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import io.restassured.response.Response;

public class PreloadData {

    ClientCreateRequestFactory clientCreateRequestFactory = ClientCreateRequestFactory.getInstance();
    BookCreateRequestFactory bookCreateRequestFactory = BookCreateRequestFactory.getInstance();

    public ClientResponse client() {
        ClientCreateRequest client = clientCreateRequestFactory.createClientCreateRequestValid();
        String json = Utils.converterParaJson(client);
        Response response = ClientClient.createClient(json);
        return response.as(ClientResponse.class);
    }

    public BookResponse book() {
        BookCreateRequest book = bookCreateRequestFactory.createBookCreateRequestValid();
        String json = Utils.converterParaJson(book);
        Response response = BookClient.createBook(json);
        return response.as(BookResponse.class);
    }
}
