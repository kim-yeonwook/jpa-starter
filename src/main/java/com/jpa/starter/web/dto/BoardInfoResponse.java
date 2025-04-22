package com.jpa.starter.web.dto;

import com.jpa.starter.infrastructure.enums.BoardStatus;
import com.jpa.starter.infrastructure.persistence.entity.Board;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class BoardInfoResponse {

    private String code;

    private String name;

    private String description;

    private BoardStatus status;

    private String createdId;

    private Date createdAt;

    private String updatedId;

    private Date updatedAt;

    private CategoryInfoResponse category;

    public static BoardInfoResponse fromEntity(Board board) {
        return BoardInfoResponse.builder()
                .code(board.getCode())
                .name(board.getName())
                .description(board.getDescription())
                .status(board.getStatus())
                .createdId(board.getCreatedId())
                .createdAt(board.getCreatedAt())
                .updatedId(board.getUpdatedId())
                .updatedAt(board.getUpdatedAt())
                .category(CategoryInfoResponse.fromEntity(board.getCategory()))
                .build();
    }
}
