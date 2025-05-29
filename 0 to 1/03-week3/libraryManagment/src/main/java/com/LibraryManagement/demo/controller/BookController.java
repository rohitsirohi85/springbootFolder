package com.LibraryManagement.demo.controller;

import com.LibraryManagement.demo.entity.Author;
import com.LibraryManagement.demo.entity.Book;
import com.LibraryManagement.demo.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;


    @PostMapping
    public Book createNewBook(@RequestBody Book book){
        return bookService.createNewBook(book);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/title/{bookTitle}")
    public Book getBookByTitle( @PathVariable String bookTitle){
        return bookService.getBookByTitle(bookTitle);
    }


    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable Long bookId){
        bookService.deleteBookById(bookId);
    }

    @PatchMapping("/{bookId}")
    public Book updateBookPartially(@PathVariable Long bookId, @RequestBody Map<String,Object> updates){
        return bookService.updateBookPartially(bookId,updates);
    }


    @PostMapping("/{bookId}/author/{authorId}")
    public Author assignBookToAuthor(@PathVariable Long bookId,@PathVariable Long authorId){
        return bookService.assignBookToAuthor(bookId,authorId);
    }



}
