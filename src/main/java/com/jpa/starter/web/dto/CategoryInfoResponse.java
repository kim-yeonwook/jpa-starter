package com.jpa.starter.web.dto;

import com.jpa.starter.infrastructure.enums.CategoryStatus;
import com.jpa.starter.infrastructure.persistence.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class CategoryInfoResponse {

    private String code;

    private String name;

    private String description;

    private CategoryStatus status;

    private String createdId;

    private Date createdAt;

    private String updatedId;

    private Date updatedAt;

    public static CategoryInfoResponse fromEntity(Category category) {
        return CategoryInfoResponse.builder()
                .code(category.getCode())
                .name(category.getName())
                .description(category.getDescription())
                .status(category.getStatus())
                .createdId(category.getCreatedId())
                .createdAt(category.getCreatedAt())
                .updatedId(category.getUpdatedId())
                .updatedAt(category.getUpdatedAt())
                .build();
    }
}
