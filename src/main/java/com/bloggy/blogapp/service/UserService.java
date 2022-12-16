package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.RoleDTO;
import com.bloggy.blogapp.controller.dto.request.RoleRequest;
import com.bloggy.blogapp.controller.dto.UserDTO;
import com.bloggy.blogapp.controller.dto.request.UserRequest;

import java.util.List;

public interface UserService {
    void saveUser(UserRequest user);
    UserDTO getUserByName(String username);
    void saveRole(RoleRequest role);
    void addRoleToUser(int userId,int roleId);

    List<UserDTO> getAllUsers();

    List<RoleDTO> getAllRoles();
}