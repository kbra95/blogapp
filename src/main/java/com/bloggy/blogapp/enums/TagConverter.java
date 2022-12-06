package com.bloggy.blogapp.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class TagConverter implements AttributeConverter<Tag, String> {
    @Override
    public String convertToDatabaseColumn(Tag attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public Tag convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Tag.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
