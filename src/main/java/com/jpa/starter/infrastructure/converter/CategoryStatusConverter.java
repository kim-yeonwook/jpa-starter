package com.jpa.starter.infrastructure.converter;

import com.jpa.starter.infrastructure.enums.CategoryStatus;
import jakarta.persistence.AttributeConverter;

public class CategoryStatusConverter implements AttributeConverter<CategoryStatus, String> {

    @Override
    public String convertToDatabaseColumn(CategoryStatus categoryStatus) {
        return categoryStatus.name();
    }

    @Override
    public CategoryStatus convertToEntityAttribute(String s) {
        return CategoryStatus.valueOf(s);
    }
}
