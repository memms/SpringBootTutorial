//package com.memms.tutorial.dao.impl;
//
//import com.memms.tutorial.TestDataUtil;
//import com.memms.tutorial.domain.Author;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import static com.memms.tutorial.TestDataUtil.createTestAuthor;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class AuthorDAOImplTests {
//
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private AuthorDAOImpl underTest;
//
//    @Test
//    public void testThatCreateAuthorGeneratesCorrectSql() {
//        Author author = createTestAuthor();
//        underTest.create(author);
//
//        verify(jdbcTemplate).update(
//                eq("INSERT INTO authors(id, name, age) VALUES(?, ?, ?)"),
//                eq(1L),
//                eq("Test Author"),
//                eq(30)
//        );
//    }
//
//    @Test
//    public void testThatFindOneGeneratesTheCorrectSql(){
//        underTest.findOne(1L);
//        verify(jdbcTemplate).query(
//                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
//                ArgumentMatchers.<AuthorDAOImpl.AuthorRowMapper>any(),
//                eq(1L)
//        );
//    }
//
//    @Test
//    public void testThatFindManyGeneratesTheCorrectSql() {
//        underTest.find();
//        verify(jdbcTemplate).query(
//                eq("SELECT id, name, age FROM authors"),
//                ArgumentMatchers.<AuthorDAOImpl.AuthorRowMapper>any()
//        );
//    }
//
//    @Test
//    public void testThatUpdateGeneratesCorrectSql() {
//        Author author = createTestAuthor();
//        underTest.update(5L, author);
//
//        verify(jdbcTemplate).update(
//                eq("UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?"),
//                eq(1L),
//                eq("Test Author"),
//                eq(30),
//                eq(5L)
//        );
//    }
//
//    @Test
//    public void testThatDeleteGeneratesCorrectSql() {
//        underTest.delete(1L);
//        verify(jdbcTemplate).update(
//                eq("DELETE FROM authors WHERE id = ?"),
//                eq(1L)
//        );
//    }
//
//
//
//}
