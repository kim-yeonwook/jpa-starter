package com.jpa.starter.web.dto;

public record SearchBoardTupleListResponse(
        String code,
        String name,
        String description,
        String titleAgg
) {
}
