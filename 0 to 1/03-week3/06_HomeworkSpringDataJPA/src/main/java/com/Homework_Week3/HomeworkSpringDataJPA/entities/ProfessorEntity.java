package com.Homework_Week3.HomeworkSpringDataJPA.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professor")
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "professor" , fetch = FetchType.LAZY)
    private List<SubjectEntity>subjects;

    @ManyToMany
    @JoinTable(name = "professor_student" , 
                                 joinColumns = @JoinColumn(name="professor_id") , 
                                  inverseJoinColumns=@JoinColumn(name="student_id"))
            @JsonIgnore                    
    private List<StudentEntity>students;

}
