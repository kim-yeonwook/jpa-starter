package com.jpa.starter.application.service;

import com.jpa.starter.domains.board.BoardService;
import com.jpa.starter.infrastructure.persistence.entity.Board;
import com.jpa.starter.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BoardApplicationService {

    private final BoardService boardService;

    public UniqueCodeResponse saveBoard(BoardSaveRequest dto) {
        String result = boardService.save(
                dto.code(),
                dto.name(),
                dto.description(),
                "test_user_id",
                dto.categoryCode()
        ).getCode();

        return new UniqueCodeResponse(result);
    }

    public UniqueCodeResponse updateBoard(String code, BoardInfoUpdateRequest dto) {
        String result = this.boardService.updateInfo(
                code,
                dto.name(),
                dto.description(),
                "test_user_id",
                dto.categoryCode()).getCode();


        return new UniqueCodeResponse(result);
    }

    public UniqueCodeResponse updateBoard(String code, BoardStatusUpdateRequest dto) {
        String result = this.boardService.updateStatus(
                code,
                dto.status(),
                "test_user_id"
        ).getCode();

        return new UniqueCodeResponse(result);
    }

    public BoardInfoResponse getBoard(String code) {
        Board board = this.boardService.info(code);
        if (Objects.isNull(board)) {
            return null;
        }

        return BoardInfoResponse.fromEntity(board);
    }

    public void deleteBoard(String code) {
        this.boardService.delete(code, "test_user_id");
    }

    public void savePost() {

    }

    public void getPost() {

    }
}
