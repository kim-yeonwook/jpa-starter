package com.jpa.starter.infrastructure.converter;

import com.jpa.starter.infrastructure.enums.PostStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PostStatusConverter implements AttributeConverter<PostStatus, String> {

    @Override
    public String convertToDatabaseColumn(PostStatus postStatus) {
        return postStatus.name();
    }

    @Override
    public PostStatus convertToEntityAttribute(String s) {
        return PostStatus.valueOf(s);
    }
}
