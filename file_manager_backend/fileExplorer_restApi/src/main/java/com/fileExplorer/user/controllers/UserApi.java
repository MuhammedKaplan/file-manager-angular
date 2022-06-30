package com.fileExplorer.user.controllers;


import com.fileExplorer.user.model.User;
import com.fileExplorer.user.model.UserDTO;
import com.fileExplorer.user.model.UserMapperImpl;
import com.fileExplorer.user.repository.UserRepository;
import com.fileExplorer.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApi {

    private UserService userService;

    private UserRepository userRepository;

    private UserMapperImpl userMapperImpl;


    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    @GetMapping(value = "/deneme",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> helloApi(){
        User user = userService.findByUsername("deneme");
        UserDTO userDto = userMapperImpl.toDTO(user);
        return ResponseEntity.ok(userDto);
    }



}