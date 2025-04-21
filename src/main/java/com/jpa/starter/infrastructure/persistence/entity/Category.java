package com.jpa.starter.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "category")
@Getter
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    private String description;

    private Integer order;

    private Boolean isDeleted;

    private String createdId;

    private LocalDateTime createdAt;

    private String updatedId;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "category")
    private Set<Board> boardSet;

}
