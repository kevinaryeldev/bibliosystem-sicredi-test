package br.com.kevinaryedev.bibliosystem.data.factory;

import br.com.kevinaryedev.bibliosystem.data.provider.DataProvider;
import br.com.kevinaryedev.bibliosystem.model.request.LoanCreateRequest;

public class LoanCreateRequestFactory {
    private static LoanCreateRequestFactory instance;
    private LoanCreateRequest invalidLoanCreateRequest;

    public static LoanCreateRequestFactory getInstance() {
        if (instance == null) {
            instance = new LoanCreateRequestFactory();
        }
        return instance;
    }

    public LoanCreateRequestFactory() {
        this.invalidLoanCreateRequest = DataProvider.getInvalidLoanCreateRequest();
    }

    public LoanCreateRequest createLoanCreateRequestWithIdCopyNull(Integer id_client){
        LoanCreateRequest loan = invalidLoanCreateRequest.clone();
        loan.setId_copy(null);
        loan.setId_client(id_client);
        return loan;
    }
    public LoanCreateRequest createLoanCreateRequestWithIdClientNull(Integer id_copy){
        LoanCreateRequest loan = invalidLoanCreateRequest.clone();
        loan.setId_client(null);
        loan.setId_copy(id_copy);
        return loan;
    }
    public LoanCreateRequest createLoanCreateRequestWithIdCopyInvalid(Integer id_client){
        LoanCreateRequest loan = invalidLoanCreateRequest.clone();
        loan.setId_client(id_client);
        return loan;
    }
    public LoanCreateRequest createLoanCreateRequestWithIdClientInvalid(Integer id_copy){
        LoanCreateRequest loan = invalidLoanCreateRequest.clone();
        loan.setId_copy(id_copy);
        return loan;
    }
    public LoanCreateRequest createLoanCreateRequestValid(Integer id_copy, Integer id_client){
        LoanCreateRequest loan = invalidLoanCreateRequest.clone();
        loan.setId_copy(id_copy);
        loan.setId_client(id_client);
        return loan;
    }
}
