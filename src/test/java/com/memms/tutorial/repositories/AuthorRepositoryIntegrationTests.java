package com.memms.tutorial.repositories;

import com.memms.tutorial.domain.entities.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static com.memms.tutorial.TestDataUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = createTestAuthor();
        underTest.save(authorEntity);
        Optional<AuthorEntity> result  = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);
    }

    @Test
    public void testThatManyAthorsCanBeCreatedAndRecalled() {
        underTest.save(createTestAuthor());
        underTest.save(createTestAuthor2());
        underTest.save(createTestAuthor3());
        Iterable<AuthorEntity> results = underTest.findAll();
        assertThat(results)
                .hasSize(3)
                .containsExactly(createTestAuthor(), createTestAuthor2(), createTestAuthor3());
    }

    @Test
    public void testThatAuthorsCanBeUpdated() {
        AuthorEntity authorEntity = createTestAuthor();
        underTest.save(authorEntity);
        authorEntity.setName("UPDATED");
        underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get())
                .isEqualTo(authorEntity);
    }

    @Test
    public void testThatAuthorsCanBeDeleted() {
        underTest.save(createTestAuthor());
        Optional<AuthorEntity> result = underTest.findById(1L);
        assertThat(result).isPresent();
        underTest.deleteById(1L);
        Iterable<AuthorEntity> results = underTest.findAll();
        assertThat(results).isEmpty();
        result = underTest.findById(1L);
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAuthorsWithAgeLessThan() {
        AuthorEntity authorEntity = createTestAuthor();
        AuthorEntity authorEntity2 = createTestAuthor2();
        AuthorEntity authorEntity3 = createTestAuthor3();
        underTest.saveAll(List.of(authorEntity, authorEntity2, authorEntity3));
        Iterable<AuthorEntity> results = underTest.ageLessThan(45);
        assertThat(results).containsExactly(authorEntity, authorEntity2);
    }

//    @Test
//    public void testThatGetAuthorsWithAgeGreaterThan() {
//        AuthorEntity authorEntity = createTestAuthor();
//        AuthorEntity authorEntity2 = createTestAuthor2();
//        AuthorEntity authorEntity3 = createTestAuthor3();
//        underTest.saveAll(List.of(authorEntity, authorEntity2, authorEntity3));
//        Iterable<AuthorEntity> results = underTest.findAuthorsWithAgeGreaterThan(45);
//        assertThat(results).containsExactly(authorEntity3);
//    }
}
