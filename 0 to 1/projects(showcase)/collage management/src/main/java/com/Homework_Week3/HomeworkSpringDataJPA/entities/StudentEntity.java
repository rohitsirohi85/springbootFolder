package com.Homework_Week3.HomeworkSpringDataJPA.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long id;
    

    @OneToOne(mappedBy = "studentRecord")
    @JsonIgnore
    private AdmissionRecordEntity admissionRecord;

    private String name;

    @ManyToMany(mappedBy = "students")
    private List<ProfessorEntity>professors;

    @ManyToMany
    @JoinTable(name = "student_subject" , joinColumns = @JoinColumn(name="student_id") , 
                                            inverseJoinColumns = @JoinColumn(name="subject_id"))
            @JsonIgnore                            
    private List<SubjectEntity>subjects;


}
