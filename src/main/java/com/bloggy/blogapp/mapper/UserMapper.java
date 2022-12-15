package com.bloggy.blogapp.mapper;

import com.bloggy.blogapp.controller.dto.*;
import com.bloggy.blogapp.repository.entity.Role;
import com.bloggy.blogapp.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    RoleDTO toRoleDTO(Role role);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toUserEntity(UserRequest userRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "users", ignore = true)
    Role toRoleEntity(RoleRequest userRequest);

    List<UserDTO> toUserDTOList(List<User> users);
    Set<RoleDTO> toRoleDTOSet(Set<Role> roles);

    List<RoleDTO> toRoleDTOList(List<Role> roles);
}
