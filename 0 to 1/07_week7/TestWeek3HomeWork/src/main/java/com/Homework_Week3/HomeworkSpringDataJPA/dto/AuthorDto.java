package com.Homework_Week3.HomeworkSpringDataJPA.dto;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Book;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Long id;

    @NotNull(message = "name must be provided")
    @NotEmpty(message = "name can't be empty")
    private String name;

    private List<Book> books;

    @PastOrPresent(message = "are you from future")
    private LocalDateTime createdAt;

}
