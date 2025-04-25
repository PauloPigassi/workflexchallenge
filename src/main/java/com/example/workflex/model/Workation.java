package com.example.workflex.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "workations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workationId;

    private String employee;

    private String origin;

    private String destination;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer workingDays;

    private String risk;
}

