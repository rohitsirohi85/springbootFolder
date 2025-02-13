package com.Homework_Week3.HomeworkSpringDataJPA.repo;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
    List<Author> findByName(String name);
}
