package com.jpa.starter.infrastructure.persistence.entity;

import com.jpa.starter.infrastructure.converter.BoardStatusConverter;
import com.jpa.starter.infrastructure.enums.BoardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "board")
@Getter
@Entity
public class Board {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    private String description;

    @Convert(converter = BoardStatusConverter.class)
    private BoardStatus status;

    private String createdId;

    private LocalDateTime createdAt;

    private String updatedId;

    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public void updateStatus(BoardStatus status, String user) {
        this.status = status;
        this.updatedId = user;
    }

    public void updateInfo(String name, String description, String user) {
        this.name = name;
        this.description = description;
        this.updatedId = user;
    }

    public void add(Category category) {
        this.category = category;
    }
}
