package br.com.kevinaryedev.bibliosystem.data.factory;

import br.com.kevinaryedev.bibliosystem.data.config.CopyDataConfig;
import br.com.kevinaryedev.bibliosystem.data.provider.DataProvider;
import br.com.kevinaryedev.bibliosystem.model.request.CopyCreateRequest;

public class CopyCreateRequestFactory {
    private static CopyCreateRequestFactory instance;
    private CopyCreateRequest validCopyCreateRequest;
    public static CopyCreateRequestFactory getInstance() {
        if (instance == null) {
            instance = new CopyCreateRequestFactory();
        }
        return instance;
    }
    private CopyCreateRequestFactory() {
        this.validCopyCreateRequest = DataProvider.getValidCopyCreateRequest();
    }
    public CopyCreateRequest createCopyCreateRequestValid(Integer bookId){
        CopyCreateRequest copy = validCopyCreateRequest.clone();
        copy.setId_book(bookId);
        return copy;
    }
    public CopyCreateRequest createCopyCreateRequestWithBookIdNull(){
        CopyCreateRequest copy = validCopyCreateRequest.clone();
        copy.setId_book(null);
        return copy;
    }
    public CopyCreateRequest createCopyCreateRequestWithBookIdInvalid(){
        CopyCreateRequest copy = validCopyCreateRequest.clone();
        return copy;
    }
    public CopyCreateRequest createCopyCreateRequestWithYearNull(Integer bookId){
        CopyCreateRequest copy = validCopyCreateRequest.clone();
        copy.setId_book(bookId);
        copy.setYear(null);
        return copy;
    }
    public CopyCreateRequest createCopyCreateRequestWithYearInvalid(Integer bookId){
        CopyCreateRequest copy = validCopyCreateRequest.clone();
        copy.setId_book(bookId);
        copy.setYear(CopyDataConfig.invalidYear());
        return copy;
    }

    public CopyCreateRequest createCopyCreateRequestWithPropertyCodeNull(Integer bookId){
        CopyCreateRequest copy = validCopyCreateRequest.clone();
        copy.setId_book(bookId);
        copy.setProperty_code(null);
        return copy;
    }
    public CopyCreateRequest createCopyCreateRequestWithEditionNull(Integer bookId){
        CopyCreateRequest copy = validCopyCreateRequest.clone();
        copy.setId_book(bookId);
        copy.setEdition(null);
        return copy;
    }
    public CopyCreateRequest createCopyCreateRequestWithEditionInvalid(Integer bookId){
        CopyCreateRequest copy = validCopyCreateRequest.clone();
        copy.setId_book(bookId);
        copy.setEdition(CopyDataConfig.invalidEdition());
        return copy;
    }

}
