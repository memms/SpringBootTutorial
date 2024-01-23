package com.memms.tutorial;

import com.memms.tutorial.domain.Author;
import com.memms.tutorial.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {}


    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Test Author")
                .age(30)
                .build();
    }

    public static Author createTestAuthor2() {
        return Author.builder()
                .id(2L)
                .name("Test Author 2")
                .age(40)
                .build();
    }

    public static Author createTestAuthor3() {
        return Author.builder()
                .id(3L)
                .name("Test Author 3")
                .age(50)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("1234567890")
                .title("Test Book")
                .authorId(1L)
                .build();
    }

    public static Book createTestBook2() {
        return Book.builder()
                .isbn("1234567891")
                .title("Test Book 2")
                .authorId(2L)
                .build();
    }

    public static Book createTestBook3() {
        return Book.builder()
                .isbn("1234567892")
                .title("Test Book 3")
                .authorId(3L)
                .build();
    }
}
