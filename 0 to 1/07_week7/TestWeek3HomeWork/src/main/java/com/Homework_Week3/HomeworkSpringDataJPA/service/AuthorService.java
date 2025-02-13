package com.Homework_Week3.HomeworkSpringDataJPA.service;

import com.Homework_Week3.HomeworkSpringDataJPA.dto.AuthorDto;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Author;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;
import com.Homework_Week3.HomeworkSpringDataJPA.exception.ResourceNotFoundException;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.AuthorRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepo.findAll();

        return authors
                .stream()
                .map(author -> modelMapper.map(author, AuthorDto.class))
                .toList();

    }

    public AuthorDto getAuthorById(Long authorId) {
        Optional<Author> author = authorRepo.findById(authorId);
        return modelMapper.map(author, AuthorDto.class);
    }

    public AuthorDto createNewAuthor(AuthorDto inputAuthor) {

        List<Author> authors = authorRepo.findByName(inputAuthor.getName());

      if (!authors.isEmpty()){
          throw new RuntimeException("employee already exist with name:"+inputAuthor.getName());
      }

        Author author = modelMapper.map(inputAuthor,Author.class);
        Author savedAuthor = authorRepo.save(author);
        return modelMapper.map(savedAuthor, AuthorDto.class);
    }

    public AuthorDto updateAuthor(AuthorDto inputAuthor, Long authorId) {
        Author author = modelMapper.map(inputAuthor, Author.class);
        author.setId(authorId);
         Author savedAuthor =  authorRepo.save(author);
         return modelMapper.map(savedAuthor, AuthorDto.class);
    }

    public AuthorDto assignBookToAuthor(Long authorId, Long bookId) {
        Optional<Author> author = authorRepo.findById(authorId);
        Optional<Book> book = bookRepo.findById(bookId);

          author
                .flatMap(author1 -> book.map(book1 -> {
                    book1.setAuthor(author1);
                    bookRepo.save(book1);

                    author1.getBooks().add(book1);
                    return authorRepo.save(author1);
                })).orElse(null);
       return  modelMapper.map(author, AuthorDto.class);
    }
}
