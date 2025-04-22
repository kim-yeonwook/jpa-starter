package com.jpa.starter.web.dto;

public record SearchBoardListRequest (
        String categoryCode,
        String startDate,
        String endDate
) {
}
