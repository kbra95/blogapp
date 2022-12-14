package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.RoleRequest;
import com.bloggy.blogapp.controller.dto.UserDTO;
import com.bloggy.blogapp.controller.dto.UserRequest;
import com.bloggy.blogapp.mapper.UserMapper;
import com.bloggy.blogapp.repository.RoleRepository;
import com.bloggy.blogapp.repository.UserRepository;
import com.bloggy.blogapp.repository.entity.Role;
import com.bloggy.blogapp.repository.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public void saveUser(UserRequest user) {
        log.info("Saving new user");
        userRepository.save(userMapper.toUserEntity(user));
    }

    @Override
    public UserDTO getUserByName(String username) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Blog post is not found with given username : %s", username)));
        return userMapper.toUserDTO(user);
    }

    @Override
    public void saveRole(RoleRequest role) {
        log.info("Saving new role");
        roleRepository.save(userMapper.toRoleEntity(role));
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding relation for the user: {}", username);
        Optional<User> user = userRepository.findByUserName(username);
        Optional<Role> role = roleRepository.findByName(roleName);
        user.ifPresent(u -> role.ifPresent(u::addRole));
    }
}