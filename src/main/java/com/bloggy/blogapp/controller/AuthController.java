package com.bloggy.blogapp.controller;

import com.bloggy.blogapp.controller.dto.RoleRequest;
import com.bloggy.blogapp.controller.dto.UserRequest;
import com.bloggy.blogapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;
    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
        log.info("The User is saved. Username :  {}" , userRequest.getUserName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/role")
    public ResponseEntity<Void> createRole(@Valid @RequestBody RoleRequest roleRequest) {
        userService.saveRole(roleRequest);
        log.info("The Role is saved. Name : {}" , roleRequest.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}