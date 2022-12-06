package com.bloggy.blogapp.enums;

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
}
