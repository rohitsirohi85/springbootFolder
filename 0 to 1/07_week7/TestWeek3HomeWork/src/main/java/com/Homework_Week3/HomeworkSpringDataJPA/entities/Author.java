package com.Homework_Week3.HomeworkSpringDataJPA.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book>books;

   @CreationTimestamp
    private LocalDateTime createdAt;
}
