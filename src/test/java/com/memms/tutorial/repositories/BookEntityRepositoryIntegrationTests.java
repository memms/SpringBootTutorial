package com.memms.tutorial.repositories;

import com.memms.tutorial.domain.entities.AuthorEntity;
import com.memms.tutorial.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.memms.tutorial.TestDataUtil.*;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    public BookEntityRepositoryIntegrationTests(BookRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = createTestAuthor();
        BookEntity bookEntity = createTestBook(authorEntity);
        underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);
    }

    @Test
    public void testThatManyBooksCanBeCreatedAndRecalled() {
        BookEntity bookEntityA = createTestBook(createTestAuthor());
        BookEntity bookEntityB = createTestBook2(createTestAuthor2());
        BookEntity bookEntityC = createTestBook3(createTestAuthor3());
        underTest.save(bookEntityA);
        underTest.save(bookEntityB);
        underTest.save(bookEntityC);
        Iterable<BookEntity> results = underTest.findAll();
        assertThat(results)
                .hasSize(3)
                .containsExactly(bookEntityA, bookEntityB, bookEntityC);
    }

    @Test
    public void testThatBooksCanBeUpdated() {
        BookEntity bookEntity = createTestBook(createTestAuthor());
        underTest.save(bookEntity);
        bookEntity.setTitle("UPDATED");
        underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);
    }

    @Test
    public void testThatBooksCanBeDeleted() {
        BookEntity bookEntity = createTestBook(createTestAuthor());
        underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        underTest.deleteById(bookEntity.getIsbn());
        result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isEmpty();
        Iterable<BookEntity> results = underTest.findAll();
        assertThat(results).isEmpty();
    }
}
