package com.memms.tutorial;

import com.memms.tutorial.domain.dto.AuthorDto;
import com.memms.tutorial.domain.dto.BookDto;
import com.memms.tutorial.domain.entities.AuthorEntity;
import com.memms.tutorial.domain.entities.BookEntity;

public final class TestDataUtil {

    private TestDataUtil() {}

    public static AuthorEntity createTestAuthor() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Test Author")
                .age(30)
                .build();

    }

        public static AuthorEntity createTestAuthor2() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Test Author 2")
                .age(40)
                .build();
    }

    public static AuthorEntity createTestAuthor3() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Test Author 3")
                .age(50)
                .build();
    }

    public static BookEntity createTestBook(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1234567890")
                .title("Test Book")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDto createTestBookDto(final AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("1234567890")
                .title("Test Book")
                .author(authorDto)
                .build();
    }
    public static BookEntity createTestBook2(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1234567891")
                .title("Test Book 2")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBook3(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1234567892")
                .title("Test Book 3")
                .authorEntity(authorEntity)
                .build();
    }

//    JDBC BELOW
//
//
//    public static Book createTestBook() {
//        return Book.builder()
//                .isbn("1234567890")
//                .title("Test Book")
//                .authorId(1L)
//                .build();
//    }
//
//    public static Book createTestBook2() {
//        return Book.builder()
//                .isbn("1234567891")
//                .title("Test Book 2")
//                .authorId(2L)
//                .build();
//    }
//
//    public static Book createTestBook3() {
//        return Book.builder()
//                .isbn("1234567892")
//                .title("Test Book 3")
//                .authorId(3L)
//                .build();
//    }
}
