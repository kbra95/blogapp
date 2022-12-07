package com.bloggy.blogapp.enums;

import java.util.stream.Stream;

public enum Tag {

    TECHNOLOGY("T"),
    SOCIAL("S"),
    POLITIC("Pc"),
    ECONOMY("EC"),
    ENTERTAIN("EN");


    private String code;

    private Tag(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Tag getByCode(String code) {
        return Stream.of(Tag.values())
                .filter(paybackActionStatus -> paybackActionStatus.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
