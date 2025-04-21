package com.jpa.starter.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/boards/{code}/posts")
@RestController
public class PostController {

    // 임시 게시글 저장
    @PostMapping
    public void draftPost() {

    }

    // 게시글 저장
    @PutMapping("/{id}")
    public void writePost(@PathVariable String code, @PathVariable Long id) {

    }

    // 게시글 수정
    @PatchMapping("/{id}")
    public void patchPost(@PathVariable String code, @PathVariable Long id) {
        
    }
    
    // 게시글 삭제
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String code, @PathVariable Long id) {

    }

    @GetMapping
    public void listPost(@PathVariable String code) {

    }

    @GetMapping("/{id}")
    public void infoPost(@PathVariable String code, @PathVariable Long id) {

    }

    @PostMapping("{id}/images")
    public void uploadImages() {

    }
}
