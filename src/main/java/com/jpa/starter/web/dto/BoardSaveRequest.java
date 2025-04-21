package com.jpa.starter.web.dto;

public record BoardSaveRequest(
        String code,
        String name,
        String description
) {
}
