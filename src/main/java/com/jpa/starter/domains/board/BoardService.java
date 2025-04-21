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

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final CategoryRepository categoryRepository;

    private final BoardRepository boardRepository;

    public Board saveBoard(String code, String name, String user, String categoryCode) {
        // 코드 중복 체크

        // 이름 중복 체크

        // 카테고리
        Category category = this.categoryRepository.findByCode(categoryCode)
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다."));

        Board board = Board.builder()
                .code(code)
                .name(name)
                .status(BoardStatus.ACTIVE)
                .createdId(user)
                .category(category)
                .build();

        return boardRepository.save(board);
    }

    public Board get(String code) {
        return boardRepository.findByCode(code)
                .orElse(null);
    }

    public void remove(String code) {
        this.boardRepository.removeByCode(code);
    }

    public Page<Board> list(SearchBoardListRequest search, Pageable pageable) {
        return null;
    }

    public List<Board> list(SearchBoardListRequest search) {
        return null;
    }
}
