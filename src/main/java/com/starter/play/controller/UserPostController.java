package com.starter.play.controller;

import com.starter.play.dto.UserDto;
import com.starter.play.service.UserPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserPostController {
    private static final Logger logger = LoggerFactory.getLogger(UserPostController.class);

    @Autowired
    private UserPostService userPostService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        logger.info("Creating user with details: {}", userDto);
        return ResponseEntity.ok(userPostService.createUser(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        logger.info("Fetching all users");
        return ResponseEntity.ok(userPostService.getAllUsers());
    }
}
