package com.jpa.starter.web.dto;

import java.util.Date;

public record SearchBoardListResponse(
        String code,
        String name,
        String description,
        String createdId,
        Date createdAt
) {
}
