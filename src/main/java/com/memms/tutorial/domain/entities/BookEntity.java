package com.memms.tutorial.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//All below are for JPA entity. Above is for jdbc
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    private String isbn;

    private String title;

//    JDBC
//    private Long authorId;

//    JPA
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;
}
