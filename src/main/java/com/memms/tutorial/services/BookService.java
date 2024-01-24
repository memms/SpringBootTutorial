package com.memms.tutorial.services;

import com.memms.tutorial.domain.entities.BookEntity;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity bookEntity);
}
