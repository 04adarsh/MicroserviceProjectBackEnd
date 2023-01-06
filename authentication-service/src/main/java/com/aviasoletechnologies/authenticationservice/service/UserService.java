package com.aviasoletechnologies.authenticationservice.service;

import com.aviasoletechnologies.authenticationservice.dto.UserResponseDto;
import com.aviasoletechnologies.authenticationservice.exception.CustomException;
import com.aviasoletechnologies.authenticationservice.jwtrequest.SignupRequest;
import com.aviasoletechnologies.authenticationservice.jwtresponse.SignupResponse;
import com.aviasoletechnologies.authenticationservice.model.Role;
import com.aviasoletechnologies.authenticationservice.model.User;
import com.aviasoletechnologies.authenticationservice.repository.RefreshTokenRepository;
import com.aviasoletechnologies.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    public UserResponseDto getUserResponse(User user){
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail((user.getEmail()));
        userResponseDto.setUsername((user.getUsername()));
        Set<Role> roles=user.getRoles();
        Set<String> rolesString=new HashSet<>();
        for(Role role:roles){
            rolesString.add(role.getName().name());
        }
        userResponseDto.setRoles(rolesString);

        return userResponseDto;
    }


//    public void deleteUser(Long id){
//        User user=this.userRepository.findById(id).orElseThrow(()-> new CustomException("User not found with id"+id));
//        this.refreshTokenRepository.deleteByUser(user);
//        this.userRepository.delete(user);
//    }

    public List<UserResponseDto> getAllUser(){
    List<User> users=this.userRepository.findAll();
    List<UserResponseDto> usersDto=new ArrayList<>();
    for(User user:users){
        UserResponseDto obj=new UserResponseDto();
        obj=this.getUserResponse(user);
        usersDto.add(obj);
    }
    return usersDto;
    }

}