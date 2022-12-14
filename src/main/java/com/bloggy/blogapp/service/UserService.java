package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.RoleRequest;
import com.bloggy.blogapp.controller.dto.UserDTO;
import com.bloggy.blogapp.controller.dto.UserRequest;

public interface UserService {
    void saveUser(UserRequest user);
    UserDTO getUserByName(String username);
    void saveRole(RoleRequest role);
    void addRoleToUser(String username,String roleName);
}