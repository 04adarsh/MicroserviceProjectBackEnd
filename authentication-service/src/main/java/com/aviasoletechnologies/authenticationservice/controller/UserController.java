package com.aviasoletechnologies.authenticationservice.controller;

import com.aviasoletechnologies.authenticationservice.dto.UserResponseDto;
import com.aviasoletechnologies.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = this.userService.getAllUser();
        return ResponseEntity.ok(users);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
//        this.userService.deleteUser(id);
//        DeleteResponse deleteResponse =new DeleteResponse("user deleted successfully");
//        return ResponseEntity.ok(deleteResponse);
//
//
//    }


}

