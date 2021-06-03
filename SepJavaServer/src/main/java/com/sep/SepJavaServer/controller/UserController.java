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
    public String register(@RequestBody String jsonBody) throws IOException {
        return userService.registerUser(jsonBody);
    }

    @GetMapping("/view")
    public Users view(@RequestBody String username){
        Users viewedUsers = userService.viewUser(username);
        return viewedUsers;
    }

    @PostMapping("/login")
    public Users login(@RequestBody String usernamePassword) throws IOException {
        Users loggedInUsers = userService.loginUser(usernamePassword);
        return loggedInUsers;
    }

    @DeleteMapping("/delete")
        public void delete(@RequestBody String username){
        userService.deleteUser(username);
    }
}



