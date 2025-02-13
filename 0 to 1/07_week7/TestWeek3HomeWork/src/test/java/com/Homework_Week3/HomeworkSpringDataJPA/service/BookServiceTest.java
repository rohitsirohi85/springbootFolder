package com.Homework_Week3.HomeworkSpringDataJPA.service;

import com.Homework_Week3.HomeworkSpringDataJPA.dto.BookDto;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepo bookRepo;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private BookService bookService;

    private Book book;
    private BookDto bookDto;

    @BeforeEach
    void setUp(){
        book = Book.builder()
                .id(1L)
                .title("success")
                .build();
        bookDto = modelMapper.map(book,BookDto.class);
    }

    @Test
    void testCreateNewBook_whenBookIsNotPresent_thenCreate() {
            when(bookRepo.findByTitle(anyString())).thenReturn(List.of());
            when(bookRepo.save(any(Book.class))).thenReturn(book);

            // act

        BookDto bookDto1 = bookService.createNewBook(bookDto);

        //assert

        assertThat(bookDto1).isNotNull();
        assertThat(bookDto1.getTitle()).isEqualTo(book.getTitle());
    }

    @Test
    void testCreateNewBook_whenBookIsPresent_thenThrowException(){
        when(bookRepo.findByTitle(bookDto.getTitle())).thenReturn(List.of(book));
        assertThatThrownBy(()-> bookService.createNewBook(bookDto))
                .isInstanceOf(RuntimeException.class)
                .isNotNull();
        verify(bookRepo).findByTitle(bookDto.getTitle());
    }

    @Test
    void testGetAllBooks_whenBooksPresent_thenReturnBooks() {
        when(bookRepo.findAll()).thenReturn(List.of(book));
        List<BookDto> bookDto1 = bookService.getAllBooks();
        assertThat(bookDto1).isNotNull();
    }

    @Test
    void getBookById() {

    }

    @Test
    void updateBook() {
    }
}