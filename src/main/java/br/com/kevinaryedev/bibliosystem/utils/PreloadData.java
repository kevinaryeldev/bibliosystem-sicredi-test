package br.com.kevinaryedev.bibliosystem.utils;

import br.com.kevinaryedev.bibliosystem.client.BookClient;
import br.com.kevinaryedev.bibliosystem.client.ClientClient;
import br.com.kevinaryedev.bibliosystem.client.CopyClient;
import br.com.kevinaryedev.bibliosystem.client.LoanClient;
import br.com.kevinaryedev.bibliosystem.data.factory.BookCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.data.factory.ClientCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.data.factory.CopyCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.data.factory.LoanCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.data.provider.DataProvider;
import br.com.kevinaryedev.bibliosystem.model.request.BookCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.request.ClientCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.request.CopyCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.request.LoanCreateRequest;
import br.com.kevinaryedev.bibliosystem.model.response.BookResponse;
import br.com.kevinaryedev.bibliosystem.model.response.ClientResponse;
import br.com.kevinaryedev.bibliosystem.model.response.CopyResponse;
import br.com.kevinaryedev.bibliosystem.model.response.LoanResponse;
import io.restassured.response.Response;

public class PreloadData {
    private PreloadData() {
    }
    private static PreloadData instance;
    public static PreloadData getInstance() {
        if (instance == null) {
            instance = new PreloadData();
        }
        return instance;
    }
    LoanCreateRequestFactory loanCreateRequestFactory = LoanCreateRequestFactory.getInstance();
    CopyCreateRequestFactory copyCreateRequestFactory = CopyCreateRequestFactory.getInstance();
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
    public CopyResponse copy(String bookId) {
        Integer id = Integer.parseInt(bookId);
        CopyCreateRequest copy = copyCreateRequestFactory.createCopyCreateRequestValid(id);
        String json = Utils.converterParaJson(copy);
        Response response = CopyClient.createCopy(json);
        return response.as(CopyResponse.class);
    }
    public LoanResponse loan() {
        ClientResponse clientResponse = this.client();
        BookResponse bookResponse = this.book();
        CopyResponse copyResponse = this.copy(bookResponse.getId().toString());
        LoanCreateRequest loanCreateRequest = loanCreateRequestFactory
                .createLoanCreateRequestValid(copyResponse.getId(), clientResponse.getId());
        String json = Utils.converterParaJson(loanCreateRequest);
        Response response = LoanClient.createLoan(json);
        return response.as(LoanResponse.class);
    }
    public void loanForClient(Integer idClient){
        BookResponse bookResponse = this.book();
        CopyResponse copyResponse = this.copy(bookResponse.getId().toString());
        CopyResponse copyResponse2 = this.copy(bookResponse.getId().toString());
        LoanCreateRequest loanCreateRequest = loanCreateRequestFactory
                .createLoanCreateRequestValid(copyResponse.getId(), idClient);
        LoanCreateRequest loanCreateRequest2 = loanCreateRequestFactory
                .createLoanCreateRequestValid(copyResponse2.getId(), idClient);
        String json = Utils.converterParaJson(loanCreateRequest);
        Response response = LoanClient.createLoan(json);
        String json2 = Utils.converterParaJson(loanCreateRequest2);
        Response response2 = LoanClient.createLoan(json2);
        return;
    }
}
