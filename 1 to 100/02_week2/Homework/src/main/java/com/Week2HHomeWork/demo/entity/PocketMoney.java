package com.Week2HHomeWork.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Pocket_money")
public class PocketMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;


    @Version
    private Long versions;

    @OneToOne
    private Student student;


}
