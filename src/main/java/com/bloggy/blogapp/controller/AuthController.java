package com.bloggy.blogapp.controller;

import com.bloggy.blogapp.controller.dto.RoleDTO;
import com.bloggy.blogapp.controller.dto.UserDTO;
import com.bloggy.blogapp.controller.dto.request.AuthenticationRequest;
import com.bloggy.blogapp.controller.dto.request.RoleRequest;
import com.bloggy.blogapp.controller.dto.request.UserRequest;
import com.bloggy.blogapp.security.JWTUtil;
import com.bloggy.blogapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;


    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        if (userDetails != null) {
            return new ResponseEntity<>(jwtUtil.generateToken(userDetails), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
        log.info("The User is saved. Username :  {}", userRequest.getUserName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/role")
    public ResponseEntity<Void> createRole(@Valid @RequestBody RoleRequest roleRequest) {
        userService.saveRole(roleRequest);
        log.info("The Role is saved. Name : {}", roleRequest.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return new ResponseEntity<>(userService.getAllRoles(), HttpStatus.OK);
    }

    @PutMapping("/{userId}/{roleId}")
    public ResponseEntity<Void> addRoleToUser(@PathVariable int userId, @PathVariable int roleId) {
        userService.addRoleToUser(userId, roleId);
        log.info("The Role is linked. User : {} , Role : {}", userId, roleId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}