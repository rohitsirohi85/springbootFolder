package com.Homework_Week3.HomeworkSpringDataJPA.dto;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.Author;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Long id;

    @NotNull(message = "title must be provided")
    @NotEmpty(message = "title can't be empty")
    private String title;


    private Author author;

    @PastOrPresent(message = "are you from future")
    private LocalDateTime createdAt;
}
