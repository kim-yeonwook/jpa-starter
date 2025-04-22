package com.jpa.starter.web.dto;

import jakarta.validation.constraints.Pattern;

public record SearchBoardListRequest (
        String categoryCode,
        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "날짜 형식이 잘못되었습니다. 올바른 형식: yyyy-MM-dd")
        String startDate,
        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "날짜 형식이 잘못되었습니다. 올바른 형식: yyyy-MM-dd")
        String endDate
) {
}
