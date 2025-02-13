package com.Homework_Week3.HomeworkSpringDataJPA.controller;

import com.Homework_Week3.HomeworkSpringDataJPA.dto.BookDto;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "10000")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class BookControllerTest {


    @Autowired
     WebTestClient webTestClient;

    @Autowired
    private BookRepo bookRepo;

    private final Book book = Book.builder()
            .id(1L)
            .title("success")
            .build();

    private final BookDto bookDto = BookDto.builder()
            .id(1L)
            .title("success")
            .build();


    @BeforeEach
    void  setUp(){
        bookRepo.deleteAll();
    }

    @Test
    void getAllBooks() {
    }

    @Test
    void testGetBookById_success() {
           Book savedBook = bookRepo.save(book);
           webTestClient.get()
                   .uri("/book/{bookId}",savedBook.getId())
                   .exchange()
                   .expectBody()
                   .jsonPath("$.id").isEqualTo(savedBook.getId());
    }

    @Test
    void testCreateNewBook_whenBookAlreadyExist_thenThrowException() {
         Book savedBook = bookRepo.save(book);
         webTestClient.post()
                 .uri("/book")
                 .exchange()
                 .expectStatus().is5xxServerError();
    }

    @Test
    void testCreateNewBook_whenBookNotExist_thenCreate() {

        webTestClient.post()
                .uri("/book")
                .bodyValue(bookDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.title").isEqualTo(book.getTitle());
    }

    @Test
    void updateBook() {
    }
}