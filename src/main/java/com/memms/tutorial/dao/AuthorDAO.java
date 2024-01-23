package com.memms.tutorial.dao;

import com.memms.tutorial.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDAO {
    void create(Author author);

    Optional<Author> findOne(long l);

    List<Author> find();
}
