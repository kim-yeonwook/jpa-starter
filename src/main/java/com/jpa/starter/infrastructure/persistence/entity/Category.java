package com.jpa.starter.infrastructure.persistence.entity;

import com.jpa.starter.infrastructure.converter.CategoryStatusConverter;
import com.jpa.starter.infrastructure.enums.CategoryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
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

    @Convert(converter = CategoryStatusConverter.class)
    private CategoryStatus status;

    private String createdId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String updatedId;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "category")
    private Set<Board> boardSet;

    public void add(Board board) {
        if (this.boardSet == null) { this.boardSet = Set.of();}
        board.add(this);
        this.boardSet.add(board);
    }
}
