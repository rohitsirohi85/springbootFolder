package com.LibraryManagement.demo.services;

import com.LibraryManagement.demo.Repo.AuthorRepo;
import com.LibraryManagement.demo.entity.Author;
import com.LibraryManagement.demo.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthorService {
   private final AuthorRepo authorRepo;

   public Author createNewAuthor(Author author) {
      return authorRepo.save(author);
   }

   public Author getAuthorById(Long authorId) {
      return authorRepo.findById(authorId).orElseThrow(()->new ResourceNotFoundException("author not found"));
   }

   public void deleteAuthorById(Long authorId) {
      authorRepo.deleteById(authorId);
   }

   public Author updateAuthorPartially(Long authorId, Map<String, Object> updates) {
      Author author = authorRepo.findById(authorId).orElseThrow(()->new ResourceNotFoundException("author not found"));
      updates.forEach((key,value)->{
         Field field = ReflectionUtils.findField(Author.class,key);
          assert field != null;
          field.setAccessible(true);
          ReflectionUtils.setField(field,author,value);
      });
      return authorRepo.save(author);
   }

   public Author getAuthorByAuthorName(String authorName) {
       return authorRepo.findByName(authorName);
   }
}
