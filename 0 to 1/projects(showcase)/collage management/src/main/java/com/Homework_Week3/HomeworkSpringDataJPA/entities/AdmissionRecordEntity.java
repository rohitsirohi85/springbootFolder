package com.Homework_Week3.HomeworkSpringDataJPA.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "admission_record")
public class AdmissionRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;


    private Integer Fees;
    
    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentRecord;

}
