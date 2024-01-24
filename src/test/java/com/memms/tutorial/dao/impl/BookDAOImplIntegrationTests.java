//package com.memms.tutorial.dao.impl;
//
//import com.memms.tutorial.dao.AuthorDAO;
//import com.memms.tutorial.domain.Author;
//import com.memms.tutorial.domain.Book;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.memms.tutorial.TestDataUtil.*;
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class BookDAOImplIntegrationTests {
//
//    private AuthorDAO authorDAO;
//    private BookDAOImpl underTest;
//
//    @Autowired
//    public BookDAOImplIntegrationTests(BookDAOImpl underTest, AuthorDAO authorDAO){
//        this.underTest = underTest;
//        this.authorDAO = authorDAO;
//    }
//
//    @Test
//    public void testThatBookCanBeCreatedAndRecalled() {
//        Author author = createTestAuthor();
//        authorDAO.create(author);
//        Book book = createTestBook();
//        underTest.create(book);
//        Optional<Book> result = underTest.findOne(book.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testThatManyBooksCanBeCreatedAndRecalled() {
//        authorDAO.create(createTestAuthor());
//        authorDAO.create(createTestAuthor2());
//        authorDAO.create(createTestAuthor3());
//        underTest.create(createTestBook());
//        underTest.create(createTestBook2());
//        underTest.create(createTestBook3());
//        List<Book> results = underTest.find();
//        assertThat(results)
//                .hasSize(3)
//                .containsExactly(createTestBook(), createTestBook2(), createTestBook3());
//    }
//
//    @Test
//    public void testThatBooksCanBeUpdated() {
//        authorDAO.create(createTestAuthor());
//        Book book = createTestBook();
//        underTest.create(book);
//        book.setTitle("UPDATED");
//        underTest.update(book.getIsbn(), book);
//        Optional<Book> result = underTest.findOne(book.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testThatBooksCanBeDeleted() {
//        authorDAO.create(createTestAuthor());
//        underTest.create(createTestBook());
//        Optional<Book> result = underTest.findOne(createTestBook().getIsbn());
//        assertThat(result).isPresent();
//        underTest.delete(createTestBook().getIsbn());
//        result = underTest.findOne(createTestBook().getIsbn());
//        assertThat(result).isEmpty();
//        List<Book> results = underTest.find();
//        assertThat(results).isEmpty();
//    }
//}
