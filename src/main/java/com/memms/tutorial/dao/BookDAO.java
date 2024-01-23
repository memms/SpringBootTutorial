package com.memms.tutorial.dao;

import com.memms.tutorial.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();
}
