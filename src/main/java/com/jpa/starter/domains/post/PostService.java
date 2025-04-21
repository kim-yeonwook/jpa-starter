package com.jpa.starter.domains.post;

import com.jpa.starter.infrastructure.persistence.entity.Post;
import com.jpa.starter.infrastructure.persistence.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post writePost() {
        return null;
    }

    public boolean removePost() {
        return false;
    }

    public Page<Post> listPost() {
        return null;
    }

    public Post getPost() {
        return null;
    }
}
