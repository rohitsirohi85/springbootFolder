package com.Homework_Week3.HomeworkSpringDataJPA.service;

import com.Homework_Week3.HomeworkSpringDataJPA.dto.BookDto;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Author;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;
import com.Homework_Week3.HomeworkSpringDataJPA.exception.ResourceNotFoundException;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;

    public BookDto  createNewBook(BookDto inputBook) {
        List<Book> books = bookRepo.findByTitle(inputBook.getTitle());

        if (!books.isEmpty()){
            throw new RuntimeException("book already exist with name:"+inputBook.getTitle());
        }
        Book bookForSave = modelMapper.map(inputBook,Book.class);
        Book savedBook = bookRepo.save(bookForSave);
        return modelMapper.map(savedBook, BookDto.class);
    }


    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        return books
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .toList();
    }

    public BookDto getBookById(Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(()->new ResourceNotFoundException("book not found"));
        return modelMapper.map(book, BookDto.class);

    }

    public BookDto updateBook(BookDto inputBook, Long bookId) {
        Book book = modelMapper.map(inputBook, Book.class);

        book.setId(bookId);

        Book savedBook = bookRepo.save(book);

        return modelMapper.map(savedBook, BookDto.class);


    }
}
