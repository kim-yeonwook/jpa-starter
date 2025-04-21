package com.jpa.starter.web.controller;

import com.jpa.starter.web.dto.BoardSaveRequest;
import com.jpa.starter.web.dto.SearchBoardListRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {



    @PostMapping
    public void save(@RequestBody BoardSaveRequest dto) {

    }

    @PatchMapping("/{code}")
    public void update(@PathVariable String code) {

    }

    @PostMapping("/{code}")
    public void delete(@PathVariable String code) {

    }

    @GetMapping
    public void list(@ModelAttribute SearchBoardListRequest dto, @PageableDefault Pageable pageable) {

    }

    @GetMapping("{code}")
    public void info(@PathVariable String code) {

    }
}
