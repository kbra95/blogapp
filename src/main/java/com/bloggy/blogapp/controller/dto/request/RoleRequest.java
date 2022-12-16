package com.bloggy.blogapp.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    @NotEmpty(message = "Please provide a name")
    private String name;
}
