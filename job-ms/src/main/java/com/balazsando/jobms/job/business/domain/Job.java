package com.balazsando.jobms.job.business.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title is mandatory")
    private String title;
    private String description;

    @Column(nullable = false)
    @NotBlank(message = "Minimum salary is mandatory")
    private String minSalary;

    @Column(nullable = false)
    @NotBlank(message = "Maximum salary is mandatory")
    private String maxSalary;

    @Column(nullable = false)
    @NotBlank(message = "Location is mandatory")
    private String location;

    @Column(nullable = false)
    @NotNull(message = "Company is mandatory")
    private Long companyId;
}
