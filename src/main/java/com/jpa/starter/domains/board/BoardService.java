package com.jpa.starter.domains.board;

import com.jpa.starter.infrastructure.enums.BoardStatus;
import com.jpa.starter.infrastructure.persistence.entity.Board;
import com.jpa.starter.infrastructure.persistence.entity.Category;
import com.jpa.starter.infrastructure.persistence.repository.BoardRepository;
import com.jpa.starter.infrastructure.persistence.repository.CategoryRepository;
import com.jpa.starter.web.dto.SearchBoardListRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final CategoryRepository categoryRepository;

    private final BoardRepository boardRepository;

    @Transactional
    public Board save(String code, String name, String description, String user, String categoryCode) {
        // 코드 중복 체크

        // 이름 중복 체크

        // 카테고리
        Category category = getCategory(categoryCode);

        Board board = Board.builder()
                .code(code)
                .name(name)
                .description(description)
                .status(BoardStatus.ACTIVE)
                .createdId(user)
                .category(category)
                .build();

        return boardRepository.save(board);
    }

    @Transactional
    public Board updateInfo(String code, String name, String description, String user, String categoryCode) {
        Board board = get(code);
        board.updateInfo(name, description, user);

        if (!board.getCategory().getCode().equals(categoryCode)) {
            Category category = getCategory(categoryCode);
            board.add(category);
        }

        return this.boardRepository.save(board);
    }

    @Transactional
    public Board updateStatus(String code, String status, String user) {
        Board board = get(code);
        board.updateStatus(BoardStatus.valueOf(status), user);

        return this.boardRepository.save(board);
    }

    @Transactional
    public void delete(String code, String user) {
        Board board = get(code);
        board.updateStatus(BoardStatus.DELETED, user);

        this.boardRepository.save(board);
    }

    public Page<Board> list(SearchBoardListRequest search, Pageable pageable) {
        return null;
    }

    public List<Board> list(SearchBoardListRequest search) {
        return null;
    }

    public Board info(String code) {
        return boardRepository.findByCodeAndStatusIn(code, BoardStatus.ACTIVE)
                .orElse(null);
    }

    private Board get(String code) {
        return boardRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("게시판이 존재하지 않습니다. code : " + code));
    }

    private Category getCategory(String code) {
        return this.categoryRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다. code : " + code));
    }
}