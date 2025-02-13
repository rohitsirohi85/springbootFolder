package com.Homework_Week3.HomeworkSpringDataJPA.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "subject")
public class SubjectEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @ManyToOne
  @JoinColumn(name = "professor_id")
  @JsonIgnore
  private ProfessorEntity professor;

  @ManyToMany(mappedBy = "subjects")
  private List<StudentEntity> students;
}
