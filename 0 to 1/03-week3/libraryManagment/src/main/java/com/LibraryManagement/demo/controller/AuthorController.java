package com.LibraryManagement.demo.controller;

import com.LibraryManagement.demo.entity.Author;
import com.LibraryManagement.demo.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public Author createNewAuthor(@RequestBody Author author){
        return authorService.createNewAuthor(author);
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/name/{authorName}")
    public Author getAuthorByAuthorName(@PathVariable String authorName){
        return authorService.getAuthorByAuthorName(authorName);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthorById(@PathVariable Long authorId){
        authorService.deleteAuthorById(authorId);
    }

    @PatchMapping("/{authorId}")
    public Author updateAuthorPartially(@PathVariable Long authorId, @RequestBody Map<String,Object>updates){
        return authorService.updateAuthorPartially(authorId,updates);
    }

}
