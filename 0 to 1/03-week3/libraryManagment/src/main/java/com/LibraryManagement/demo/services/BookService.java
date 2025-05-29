package com.LibraryManagement.demo.services;

import com.LibraryManagement.demo.Repo.AuthorRepo;
import com.LibraryManagement.demo.Repo.BookRepo;
import com.LibraryManagement.demo.entity.Author;
import com.LibraryManagement.demo.entity.Book;
import com.LibraryManagement.demo.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public Book createNewBook(Book book) {
        return bookRepo.save(book);
    }

    public Book getBookById(Long bookId) {
        return bookRepo.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("book not found"));
    }

    public Book getBookByTitle(String bookTitle) {
        return bookRepo.findByTitle(bookTitle);
    }

    public void deleteBookById(Long bookId) {
        bookRepo.deleteById(bookId);
    }

    public Book updateBookPartially(Long bookId, Map<String, Object> updates) {
        Book book = bookRepo.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("book not found"));
        updates.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Book.class,key);
            assert field != null;
            field.setAccessible(true);
            ReflectionUtils.setField(field,book,value);
        });
        return  bookRepo.save(book);
    }

    public Author assignBookToAuthor(Long bookId, Long authorId) {
        Book book = bookRepo.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("book not found"));
        Author author = authorRepo.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("author not found"));
        book.setAuthor(author);
        author.getBooks().add(book);
        bookRepo.save(book);
        return authorRepo.save(author);
    }


}
