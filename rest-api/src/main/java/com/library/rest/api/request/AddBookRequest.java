package com.library.rest.api.request;

import com.library.domain.book.Book;

/**
 *
 * @author gdimitrova
 */
public class AddBookRequest extends ValueHolderRequest<Book> {
    
    public AddBookRequest(Book value) {
        super(value);
    }
    
}
