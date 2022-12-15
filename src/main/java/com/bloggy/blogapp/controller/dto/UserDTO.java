package com.bloggy.blogapp.controller.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String userName;
    private String password;
    @Builder.Default
    private Set<RoleDTO> roles = new HashSet<>();
}
