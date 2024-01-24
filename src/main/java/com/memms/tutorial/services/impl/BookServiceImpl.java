package com.memms.tutorial.services.impl;

import com.memms.tutorial.domain.entities.BookEntity;
import com.memms.tutorial.repositories.BookRepository;
import com.memms.tutorial.services.BookService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public BookEntity createBook(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }
}
