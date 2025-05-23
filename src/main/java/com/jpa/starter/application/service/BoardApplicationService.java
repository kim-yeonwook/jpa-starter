package com.jpa.starter.application.service;

import com.jpa.starter.domains.board.BoardService;
import com.jpa.starter.infrastructure.persistence.entity.Board;
import com.jpa.starter.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public Page<SearchBoardListResponse> getBoardList(SearchBoardListRequest request, Pageable pageable) {
        return this.boardService.list(request, pageable)
                .map(b -> new SearchBoardListResponse(
                        b.getCode(),
                        b.getName(),
                        b.getDescription(),
                        b.getCreatedId(),
                        b.getCreatedAt()
                ));
    }

    public List<SearchBoardListResponse> getBoardList(SearchBoardListRequest request) {
        return this.boardService.list(request)
                .stream()
                .map(b -> new SearchBoardListResponse(
                        b.getCode(),
                        b.getName(),
                        b.getDescription(),
                        b.getCreatedId(),
                        b.getCreatedAt()
                )).collect(Collectors.toList());
    }

    public Page<SearchBoardTupleListResponse> getTupleList(SearchBoardListRequest request) {
        return null;
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
