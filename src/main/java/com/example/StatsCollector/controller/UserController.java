package com.example.StatsCollector.controller;

import com.example.StatsCollector.model.Users;
import com.example.StatsCollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/profile")
    public ResponseEntity<Users> findUsersByJwtToken(@RequestHeader("Authorization") String jwt) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
        return new ResponseEntity<>(users, HttpStatus.OK);

    }
}
