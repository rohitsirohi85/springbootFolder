package com.Homework_Week3.HomeworkSpringDataJPA.controller;

import com.Homework_Week3.HomeworkSpringDataJPA.dto.AuthorDto;
import com.Homework_Week3.HomeworkSpringDataJPA.dto.BookDto;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.AuthorRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;


    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping(path = "/{authorId}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long authorId){
        return ResponseEntity.ok(authorService.getAuthorById(authorId));
    }



    @PostMapping
    public ResponseEntity<AuthorDto>createNewAuthor(@RequestBody AuthorDto inputAuthor){
        return new ResponseEntity<>(authorService.createNewAuthor(inputAuthor), HttpStatus.CREATED);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto inputAuthor, @PathVariable Long authorId){
        return ResponseEntity.ok(authorService.updateAuthor(inputAuthor,authorId));
    }

    @PutMapping("/{authorId}/book/{bookId}")
    public ResponseEntity<AuthorDto> assignBookToAuthor(@PathVariable Long authorId , @PathVariable Long bookId){
        return ResponseEntity.ok(authorService.assignBookToAuthor(authorId,bookId));
    }


}
