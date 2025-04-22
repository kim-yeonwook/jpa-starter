package com.jpa.starter.infrastructure.persistence.entity;

import com.jpa.starter.infrastructure.converter.PostStatusConverter;
import com.jpa.starter.infrastructure.enums.PostStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.Set;

@Table(name = "post")
@Getter
@Entity
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    private String content;

    @Convert(converter = PostStatusConverter.class)
    private PostStatus status;

    private Long views;

    private String createdId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private String updatedId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "post")
    private Set<PostImage> postImageSet;

    @OneToMany(mappedBy = "post")
    private Set<Comment> commentSet;

    public void add(PostImage postImage) {
        if (postImageSet == null) { postImageSet = Set.of();}
        postImage.add(this);
        postImageSet.add(postImage);
    }

    public void add(Comment comment) {
        if (commentSet == null) { commentSet = Set.of();}
        comment.add(this);
        commentSet.add(comment);
    }
}
