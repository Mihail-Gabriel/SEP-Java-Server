package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.service.IUserService;
import com.sep.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public String register(@RequestBody String username, String password, String address, String telephoneNo, String city, String role) throws IOException {
        return userService.registerUser(username,password,address,telephoneNo,city,role);
    }

    @GetMapping("/view")
    public Users view(@RequestBody String username){
        Users viewedUsers = userService.viewUser(username);
        return viewedUsers;
    }

    @GetMapping("/login")
    public Users login(@RequestBody String username, String password){
        Users loggedInUsers = userService.loginUser(username,password);
        return loggedInUsers;
    }

    @DeleteMapping("/delete")
        public void delete(@RequestBody String username){
        userService.deleteUser(username);
    }
}



