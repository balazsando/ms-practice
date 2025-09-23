package com.balazsando.reviewms.review.business.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Description is mandatory")
    private String description;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private long companyId;
}
