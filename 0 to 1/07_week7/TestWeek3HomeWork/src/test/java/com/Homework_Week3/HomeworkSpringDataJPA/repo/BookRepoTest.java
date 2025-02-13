package com.Homework_Week3.HomeworkSpringDataJPA.repo;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // fro using h2 database
class BookRepoTest {

    @Autowired
    private BookRepo bookRepo;

    private Book book;

    @BeforeEach
    void setUp(){
        book = Book.builder()
                .id(1L)
                .title("maharana-pratap")
                .build();
    }

    @Test
    void testFindByTitle_whenTitlePresent_thenReturnBook() {
//assign

        bookRepo.save(book);

//        act

        List<Book> bookList = bookRepo.findByTitle(book.getTitle());

//        assert
        assertThat(bookList).isNotNull();
        assertThat(bookList).isNotEmpty();
        assertThat(bookList.get(0).getTitle()).isEqualTo(book.getTitle());
    }

    @Test
    void testFindByTitle_whenTitleIsNotPresent_thenReturnEmpty(){
        List<Book> bookList = bookRepo.findByTitle(book.getTitle());

        assertThat(bookList).isNotNull();
        assertThat(bookList).isEmpty();
    }
}