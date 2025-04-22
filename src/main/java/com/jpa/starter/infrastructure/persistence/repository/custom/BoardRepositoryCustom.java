package com.jpa.starter.infrastructure.persistence.repository.custom;

import com.jpa.starter.infrastructure.persistence.entity.Board;
import com.jpa.starter.web.dto.SearchBoardListRequest;
import com.jpa.starter.web.dto.SearchBoardTupleListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepositoryCustom {

    Page<Board> boardList(SearchBoardListRequest request, Pageable pageable);

    List<Board> boardList(SearchBoardListRequest request);

    Page<SearchBoardTupleListResponse> boardListTuple(SearchBoardListRequest request, Pageable pageable);
}
