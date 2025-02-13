package com.Homework_Week3.HomeworkSpringDataJPA.repo;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book , Long> {
    List<Book> findByTitle(String title);
}
