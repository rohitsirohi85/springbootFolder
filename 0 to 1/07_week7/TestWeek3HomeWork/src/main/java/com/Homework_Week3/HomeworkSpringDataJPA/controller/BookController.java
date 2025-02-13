package com.Homework_Week3.HomeworkSpringDataJPA.controller;

import com.Homework_Week3.HomeworkSpringDataJPA.dto.BookDto;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.BookRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId){
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }



    @PostMapping
    public ResponseEntity<BookDto>createNewBook(@RequestBody BookDto inputBook){
        return new ResponseEntity<>(bookService.createNewBook(inputBook),HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto inputBook , @PathVariable Long bookId){
        return ResponseEntity.ok(bookService.updateBook(inputBook,bookId));
    }


}
