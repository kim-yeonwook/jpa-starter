package com.jpa.starter.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "comment")
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    public void add(Post post) {
        this.post = post;
    }
}
