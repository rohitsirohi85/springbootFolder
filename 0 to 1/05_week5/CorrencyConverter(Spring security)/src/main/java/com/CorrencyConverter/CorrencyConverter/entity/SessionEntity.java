package com.CorrencyConverter.CorrencyConverter.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Session belongs to a user (many sessions per user)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String token;

    // Automatically sets the time when the session was created
    @CreationTimestamp
    private LocalDateTime createdAt;





}
