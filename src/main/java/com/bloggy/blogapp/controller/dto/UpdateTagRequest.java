package com.bloggy.blogapp.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateTagRequest {
    private Operation operation;
    private String tagName;

    public enum Operation{
        ADD,REMOVE
    }
}
