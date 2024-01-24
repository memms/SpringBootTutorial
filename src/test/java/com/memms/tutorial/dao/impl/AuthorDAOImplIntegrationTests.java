//package com.memms.tutorial.dao.impl;
//
//import com.memms.tutorial.domain.Author;
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
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class AuthorDAOImplIntegrationTests {
//
//    private AuthorDAOImpl underTest;
//
//    @Autowired
//    public AuthorDAOImplIntegrationTests(AuthorDAOImpl underTest){
//        this.underTest = underTest;
//    }
//
//    @Test
//    public void testThatAuthorCanBeCreatedAndRecalled() {
//        Author author = createTestAuthor();
//        underTest.create(author);
//        Optional<Author> result  = underTest.findOne(author.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(author);
//    }
//
//    @Test
//    public void testThatManyAthorsCanBeCreatedAndRecalled() {
//        underTest.create(createTestAuthor());
//        underTest.create(createTestAuthor2());
//        underTest.create(createTestAuthor3());
//        List<Author> results = underTest.find();
//        assertThat(results)
//                .hasSize(3)
//                .containsExactly(createTestAuthor(), createTestAuthor2(), createTestAuthor3());
//    }
//
//    @Test
//    public void testThatAuthorsCanBeUpdated() {
//        Author author = createTestAuthor();
//        underTest.create(author);
//        author.setName("UPDATED");
//        underTest.update(author.getId(), author);
//        Optional<Author> result = underTest.findOne(author.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get())
//                .isEqualTo(author);
//    }
//
//    @Test
//    public void testThatAuthorsCanBeDeleted() {
//        underTest.create(createTestAuthor());
//        Optional<Author> result = underTest.findOne(1L);
//        assertThat(result).isPresent();
//        underTest.delete(1L);
//        List<Author> results = underTest.find();
//        assertThat(results).isEmpty();
//        result = underTest.findOne(1L);
//        assertThat(result).isEmpty();
//    }
//}
