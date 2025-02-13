package com.codingshuttle.cachingApp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;

    @Version
    private Long version;   // used for optimistic locking

    @OneToOne
    private Employee employee;
}
