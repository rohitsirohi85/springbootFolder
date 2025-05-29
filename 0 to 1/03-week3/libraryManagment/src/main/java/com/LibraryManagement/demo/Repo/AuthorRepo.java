package com.LibraryManagement.demo.Repo;

import com.LibraryManagement.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {

    Author findByName(String authorName);
}
