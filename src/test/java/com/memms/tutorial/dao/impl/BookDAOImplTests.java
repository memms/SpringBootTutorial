package com.memms.tutorial.dao.impl;

import com.memms.tutorial.TestDataUtil;
import com.memms.tutorial.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class BookDAOImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDAOImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBook();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books(isbn, title, author_id) VALUES(?, ?, ?)"),
                eq("1234567890"),
                eq("Test Book"),
                eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesTheCorrectSql() {
        underTest.findOne("1234567890");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id, FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDAOImpl.BookRowMapper>any(),
                eq("1234567890")
        );
    }

    @Test
    public void testThatFindManyBookGeneratesTheCorrectSql() {
        underTest.find();

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDAOImpl.BookRowMapper>any()
        );
    }
}
