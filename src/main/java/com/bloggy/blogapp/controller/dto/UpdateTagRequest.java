package com.bloggy.blogapp.controller.dto;

import lombok.Getter;

@Getter
public class UpdateTagRequest {
    private Operation operation;
    private String tagName;

    public enum Operation{
        ADD,REMOVE
    }
}
