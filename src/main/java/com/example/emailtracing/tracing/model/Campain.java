package com.example.emailtracing.tracing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campain")
public class Campain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campainId;
    @Column
    private String campainName;
}
