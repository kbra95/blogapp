package com.bloggy.blogapp.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String name;
    @NotEmpty(message = "Please provide a username")
    private String userName;
    @NotEmpty(message = "Please provide a password")
    private String password;
}
