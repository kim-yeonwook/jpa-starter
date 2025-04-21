package com.jpa.starter.infrastructure.persistence.repository;

import com.jpa.starter.infrastructure.persistence.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
