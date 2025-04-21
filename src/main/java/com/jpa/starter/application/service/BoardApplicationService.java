package com.jpa.starter.application.service;

import com.jpa.starter.domains.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardApplicationService {

    private final BoardService boardService;

    public void savePost() {

    }

    public void getPost() {

    }
}
