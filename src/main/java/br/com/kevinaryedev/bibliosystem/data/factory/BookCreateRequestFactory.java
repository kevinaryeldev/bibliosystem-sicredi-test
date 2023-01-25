package br.com.kevinaryedev.bibliosystem.data.factory;

import br.com.kevinaryedev.bibliosystem.data.config.BookDataConfig;
import br.com.kevinaryedev.bibliosystem.data.provider.DataProvider;
import br.com.kevinaryedev.bibliosystem.model.request.BookCreateRequest;

public class BookCreateRequestFactory {
    private static BookCreateRequestFactory instance;

    private BookCreateRequest validBookCreateRequest;

    public static BookCreateRequestFactory getInstance() {
        if (instance == null) {
            instance = new BookCreateRequestFactory();
        }
        return instance;
    }

    private BookCreateRequestFactory() {
        this.validBookCreateRequest = DataProvider.getValidBookCreateRequest();
    }

    public BookCreateRequest createBookCreateRequestValid(){
        return validBookCreateRequest.clone();
    }

    public BookCreateRequest createBookCreateRequestWithTitleNull(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setTitle(null);
        return book;
    }

    public BookCreateRequest createBookCreateRequestWithCodeNull(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setCode(null);
        return book;
    }

    public BookCreateRequest createBookCreateRequestWithSubtitleNull(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setSubtitle(null);
        return book;
    }

    public BookCreateRequest createBookCreateRequestWithPublisherNull(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setPublisher(null);
        return book;
    }

    public BookCreateRequest createBookCreateRequestWithAuthorNull(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setAuthor(null);
        return book;
    }

    public BookCreateRequest createBookCreateRequestWithCddNull(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setCdd(null);
        return book;
    }

    public BookCreateRequest createBookCreateRequestWithCodeInvalid(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setCode(BookDataConfig.invalidCode());
        return book;
    }
    public BookCreateRequest createBookCreateRequestWithPublisherInvalid(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setPublisher(BookDataConfig.invalidPublisher());
        return book;
    }
    public BookCreateRequest createBookCreateRequestWithAuthorInvalid(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setAuthor(BookDataConfig.invalidAuthor());
        return book;
    }
    public BookCreateRequest createBookCreateRequestWithCddInvalid(){
        BookCreateRequest book = validBookCreateRequest.clone();
        book.setCdd(BookDataConfig.invalidCdd());
        return book;
    }

}
