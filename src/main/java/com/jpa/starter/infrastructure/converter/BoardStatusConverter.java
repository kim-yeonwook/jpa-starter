package com.jpa.starter.infrastructure.converter;

import com.jpa.starter.infrastructure.enums.BoardStatus;
import jakarta.persistence.AttributeConverter;

public class BoardStatusConverter implements AttributeConverter<BoardStatus, String> {

    @Override
    public String convertToDatabaseColumn(BoardStatus boardStatus) {
        return boardStatus.name();
    }

    @Override
    public BoardStatus convertToEntityAttribute(String s) {
        return BoardStatus.valueOf(s);
    }
}
